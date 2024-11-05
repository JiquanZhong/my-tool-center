package com.github.jiquanzhong.toolcenter.controller;

import io.milvus.v2.client.ConnectConfig;
import io.milvus.v2.client.MilvusClientV2;
import io.milvus.v2.service.collection.request.AddFieldReq;
import io.milvus.v2.service.collection.request.CreateCollectionReq;
import io.milvus.v2.service.collection.request.GetLoadStateReq;

public class MilvusTestController {
    public static void main(String[] args) {
        String CLUSTER_ENDPOINT = "http://localhost:19530";

        // 1. Connect to Milvus server
        ConnectConfig connectConfig = ConnectConfig.builder().
                uri(CLUSTER_ENDPOINT).
                build();

        MilvusClientV2 client = new MilvusClientV2(connectConfig);

        CreateCollectionReq.CollectionSchema schema = client.createSchema();
//
//        schema.addField(AddFieldReq.builder()
//                .fieldName("vector")
//                .ddd
    }
}
