package cn.jimmy.dp30.front.controller.eg0;

public class FrontController {
  private Dispatcher dispatcher;
  
  public FrontController() {
    this.dispatcher = new Dispatcher();
  }
  
  private boolean isAuthenticUser() {
    System.out.println("User is authenticated successfully");
    return true;
  }
  
  private void trackRequest(String request) {
    System.out.println("track request: " + request);
  }
  
  public void dispatchRequest(String request) {
    trackRequest(request);
    if (isAuthenticUser()) {
      dispatcher.dispatch(request);
    }
  }
}
