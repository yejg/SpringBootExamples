package io.ymq.swagger.model;

/**
 * @author yejg
 * @since 2019-08-27
 */
public class TestResponse {

    private String id;
    private String name;

    public TestResponse() {
    }

    public TestResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
