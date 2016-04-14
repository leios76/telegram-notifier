package kr.nor.spring.rest.services.impl.telegram;

import kr.nor.spring.rest.services.impl.telegram.struct.Message;

public class SendMessageResponse extends CommonResponse {
    private Message result;

    public Message getResult() {
        return result;
    }

    public void setResult(Message result) {
        this.result = result;
    }
}
