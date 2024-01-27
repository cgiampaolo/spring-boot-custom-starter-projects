package it.home.starter.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.home.starter.pojo.FilterCriteria;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterUtils {

    public static String convertOperationJsonInUriString(String urlSvc, String pathSvc,String queryJsonString) {
        String urlCompleted = urlSvc + pathSvc + "?_q=" + queryJsonString + "&_st=PUBLIC";
        URI uri = UriComponentsBuilder.fromUriString(urlCompleted).build().encode().toUri();
        return uri.toString();
    }

    public static String convertOperationInJson(List<FilterCriteria> filterCriteriaList, String operator) throws JsonProcessingException {
        Map<String, List<Object>> queryMap = new HashMap<String, List<Object>>();
        Map<String, Object> fragmentQueryMap = new HashMap<String, Object>();
        filterCriteriaList.stream().forEach( x -> {
                    Map<String, Object> singleQuery = new HashMap<String,Object>();
                    singleQuery.put(x.getOperation(),x.getValue()); // nodo più basso
                    fragmentQueryMap.put(x.getFilterKey(), singleQuery);
                }
        );
        queryMap.put(operator,List.of(fragmentQueryMap));
        return new ObjectMapper().writeValueAsString(queryMap);
    }


    public static String convertListInJson(List<String> objectIdList, String parameter) throws JsonProcessingException {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        Map<String, List<String>> operationMap = new HashMap<String, List<String>>();
        operationMap.put("$in", objectIdList);
        queryMap.put(parameter, operationMap);
        return new ObjectMapper().writeValueAsString(queryMap);
    }
}
