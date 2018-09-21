package comp5216.sydney.edu.au.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://covert-hips.000webhostapp.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String username,
                           int age, String password,
                           double weight, double height, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("age", age + "");
        params.put("weight", weight + "");
        params.put("height", height + "");


    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
