package core;

public interface IRestApi<Request, Response> extends IBaseApi<Request, Response>{

    boolean validate(Request request);

    String urlBuilder(Request request);
}
