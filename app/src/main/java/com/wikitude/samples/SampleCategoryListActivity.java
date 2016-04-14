package com.wikitude.samples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wikitude.nativesdksampleapp.R;
import com.wikitude.samples.camera.CameraControlsActivity;
import com.wikitude.samples.plugins.BarcodePluginActivity;
import com.wikitude.samples.plugins.FaceDetectionPluginActivity;
import com.wikitude.samples.recognition.client.ClientTracking3DActivity;
import com.wikitude.samples.recognition.client.ExtendedClientTrackingActivity;
import com.wikitude.samples.recognition.client.SimpleClientTrackingActivity;
import com.wikitude.samples.recognition.cloud.ContinuousCloudTrackingActivity;
import com.wikitude.samples.recognition.cloud.OnClickCloudTrackingActivity;
import com.wikitude.samples.rendering.external.ExternalRenderingActivity;
import com.wikitude.samples.rendering.internal.InternalRenderingActivity;


public class SampleCategoryListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String EXTRAS_CATEGORY_POSITION = "categoryPosition";

    private ListView _listView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        _listView = (ListView) findViewById(R.id.sample_list);

        ArrayAdapter<CharSequence> adapter = null;
        switch (getIntent().getExtras().getInt(EXTRAS_CATEGORY_POSITION)) {
            case 0:
                adapter = ArrayAdapter.createFromResource(this, R.array.clientRecognition_samples, android.R.layout.simple_list_item_1);
                break;
            case 1:
                adapter = ArrayAdapter.createFromResource(this, R.array.cloudRecognition_samples, android.R.layout.simple_list_item_1);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this, R.array.rendering_samples, android.R.layout.simple_list_item_1);
                break;
            case 3:
                adapter = ArrayAdapter.createFromResource(this, R.array.plugins_samples, android.R.layout.simple_list_item_1);
                break;
            case 4:
                adapter = ArrayAdapter.createFromResource(this, R.array.cameraControl_samples, android.R.layout.simple_list_item_1);
                break;

        }

        _listView.setAdapter(adapter);
        _listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(final AdapterView<?> adapterView_, final View view_, final int position, final long id) {
        String itemValue = (String) _listView.getItemAtPosition(position);
        itemValue = itemValue.substring(0,3);
        Class activityClass = null;
        switch (itemValue) {
            case "1.1":
                activityClass = SimpleClientTrackingActivity.class;
                break;
            case "1.2":
                activityClass = ExtendedClientTrackingActivity.class;
                break;
            case "1.3":
                activityClass = ClientTracking3DActivity.class;
                break;
            case "2.1":
                activityClass = OnClickCloudTrackingActivity.class;
                break;
            case "2.2":
                activityClass = ContinuousCloudTrackingActivity.class;
                break;
            case "3.1":
                activityClass = InternalRenderingActivity.class;
                break;
            case "3.2":
                activityClass = ExternalRenderingActivity.class;
                break;
            case "4.1":
                activityClass = BarcodePluginActivity.class;
                break;
            case "4.2":
                activityClass = FaceDetectionPluginActivity.class;
                break;
            case "5.1":
                activityClass = CameraControlsActivity.class;
                break;
        }
        final Intent intent = new Intent( this, activityClass );
        startActivity(intent);
    }
}
