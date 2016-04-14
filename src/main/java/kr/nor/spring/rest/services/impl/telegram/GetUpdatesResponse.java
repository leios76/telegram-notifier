package kr.nor.spring.rest.services.impl.telegram;

import kr.nor.spring.rest.services.impl.telegram.struct.Update;

import java.util.List;

public class GetUpdatesResponse extends CommonResponse {
    private List<Update> result;

    public List<Update> getResult() {
        return result;
    }

    public void setResult(List<Update> result) {
        this.result = result;
    }

}
