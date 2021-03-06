package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.json.JSONException;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuniversalhelper.Log.AKLogFunctions;

/**
 * Created by AAKASH on 5/19/2016.
 */
public class LogMessagesActivity extends AppCompatActivity {
    Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_messages);

        mContext = this;
    }

    public void ActionClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_log_error_exception:
            case R.id.btn_log_debug_exception:
            case R.id.btn_log_info_exception:
            case R.id.btn_log_verbose_exception:
            case R.id.btn_log_warn_exception:
                //AKLogFunctions.ErrorMessage(getClass(), "LOG ERROR", new Exception("This is error log message"));
                RaiseError(view.getTag().toString());
                break;
        }
    }

    private void RaiseError(String tag)
    {
        try
        {
            throw new ClassNotFoundException("This is a sample class not found exception");
        }
        catch (ClassNotFoundException e)
        {
            switch (tag)
            {
                case "e":
                    AKLogFunctions.ErrorMessage(getClass(), "LOG ERROR", e);
                    break;
                case "d":
                    AKLogFunctions.DebugMessage(getClass(), "LOG DEBUG", e);
                    break;
                case "i":
                    AKLogFunctions.InfoMessage(getClass(), "LOG INFO", e);
                    break;
                case "w":
                    AKLogFunctions.WarnMessage(getClass(), "LOG WARNING", e);
                    break;
                case "v":
                    AKLogFunctions.VerboseMessage(getClass(), "LOG VERBOSE", e);
                    break;
            }
        }

        try
        {
            throw new JSONException("This is a sample json exception");
        }
        catch (JSONException e)
        {
            switch (tag)
            {
                case "e":
                    AKLogFunctions.ErrorMessage(getClass(), null, e);
                    break;
                case "d":
                    AKLogFunctions.DebugMessage(getClass(), null, e);
                    break;
                case "i":
                    AKLogFunctions.InfoMessage(getClass(), null, e);
                    break;
                case "w":
                    AKLogFunctions.WarnMessage(getClass(), null, e);
                    break;
                case "v":
                    AKLogFunctions.VerboseMessage(getClass(), null, e);
                    break;
            }
        }
    }
}
