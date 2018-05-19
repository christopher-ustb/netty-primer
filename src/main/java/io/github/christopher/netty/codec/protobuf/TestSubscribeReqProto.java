package io.github.christopher.netty.codec.protobuf;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;

public class TestSubscribeReqProto {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("christopher");
        builder.setProductName("netty-primer");
        List<String> addressList = new ArrayList<String>();
        addressList.add("Shanghai Nanjing Road");
        addressList.add("Beijing Xidan");
        addressList.add("Nanjing Xinjiekou");
        builder.addAllAddress(addressList);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode: " + req);
        byte[] body = encode(req);
        SubscribeReqProto.SubscribeReq req2 = decode(body);
        System.out.println("After decode: " + req2);
        System.out.println("Assert equals: -->" + req.equals(req2));
    }
}
