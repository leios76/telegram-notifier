package kr.nor.spring.rest.services.impl.telegram;

import kr.nor.spring.rest.services.impl.telegram.struct.Update;

import java.util.List;

public class GetUpdatesResult {
    private boolean ok;
    private List<Update> result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<Update> getResult() {
        return result;
    }

    public void setResult(List<Update> result) {
        this.result = result;
    }
}
