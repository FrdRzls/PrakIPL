import java.util.regex.Pattern;

public class Comments {

  // Returns an instance of the Responder being tested.
  protected abstract Responder responderInstance();

  // renaming the function: responderBeingTested
  // format matched kk:mm:ss EEE, MMM dd, yyyy
  Pattern timeMatcher = Pattern.compile("\\d*:\\d*:\\d* \\w*, \\w* \\d*,\\d*");
}
