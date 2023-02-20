package com.meiken;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContentGenerator;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import java.io.IOException;
import java.util.List;

public class UserService {
    private String USER_INDEX = "user_index";

    // 增加一条记录
    public void insert(User user){
        IndexRequest indexRequest = new IndexRequest(USER_INDEX);

        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);


        GetRequest getRequest = new GetRequest(USER_INDEX, "id");
        try {
            EsClient.getClient().exists( null, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // 删除一条记录
    public void delete(Long id){
        DeleteRequest deleteRequest = new DeleteRequest(USER_INDEX, "id");
        try {
            EsClient.getClient().delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 更新一条记录
    public void update(User user){

    }

    // ID查询记录
    public User get(Long id){
        GetRequest getRequest = new GetRequest(USER_INDEX, "id");
        try {
            EsClient.getClient().get(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 根据字读查询
    public List<User> query(){
        SearchRequest searchRequest  = new SearchRequest(USER_INDEX);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from();
        searchSourceBuilder.size();


        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("张三","name", "address");
        searchSourceBuilder.query(multiMatchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        try {
            SearchResponse searchResponse = EsClient.getClient().search(searchRequest, RequestOptions.DEFAULT);
            SearchHit[] hitsArray = searchResponse.getHits().getHits();

            for(SearchHit documentFields : hitsArray){
                documentFields.getId();
                String sourceJSON = documentFields.getSourceAsString();

            }

            // 总记录数
            Long total = searchResponse.getHits().getTotalHits().value;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String searchByScrollPage(){
        SearchRequest searchRequest  = new SearchRequest(USER_INDEX);
        searchRequest.scroll(TimeValue.MINUS_ONE);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size();


        // 匹配条件
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("张三","name", "address");
        searchSourceBuilder.query(multiMatchQueryBuilder);

        // 设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.field("address");
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        searchSourceBuilder.highlighter(highlightBuilder);


        searchRequest.source(searchSourceBuilder);

        try {
            SearchResponse searchResponse = EsClient.getClient().search(searchRequest, RequestOptions.DEFAULT);
            SearchHit[] hitsArray = searchResponse.getHits().getHits();

            for(SearchHit documentFields : hitsArray){
                documentFields.getId();
                String sourceJSON = documentFields.getSourceAsString();

                // 获取对应的高亮的内容
                documentFields.getHighlightFields();

            }

            // 总记录数
            Long total = searchResponse.getHits().getTotalHits().value;
            String scrollId = searchResponse.getScrollId();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    // search template



}
