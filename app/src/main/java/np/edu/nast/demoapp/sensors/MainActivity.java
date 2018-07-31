package np.edu.nast.demoapp.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "MainActivity";
    SensorManager sensorManager;
    Sensor accelerometer, mGyro, mMagno, mLight, mPressure, mTemp, mHumidity;
    TextView tvX, tvY, tvZ;
    TextView tvXGyro, tvYGyro, tvZGyro,
            tvXMagno, tvYMagno, tvZMagno,
            tvLight, tvPressure, tvHumidity, tvTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvX = findViewById(R.id.x_value);
        tvY = findViewById(R.id.y_value);
        tvZ = findViewById(R.id.z_value);

        tvXGyro = findViewById(R.id.x_gyro_value);
        tvYGyro = findViewById(R.id.y_gyro_value);
        tvZGyro = findViewById(R.id.z_gyro_value);

        tvXMagno = findViewById(R.id.x_magno_value);
        tvYMagno = findViewById(R.id.y_magno_value);
        tvZMagno = findViewById(R.id.z_magno_value);

        tvLight = findViewById(R.id.light_value);
        tvPressure = findViewById(R.id.pressure_value);
        tvHumidity = findViewById(R.id.humidity_value);
        tvTemperature = findViewById(R.id.temp_value);

        Log.d(TAG, "onCreate: Initialising sensor services...");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometer != null) {
            sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered acceloremter listener");
        } else {
            tvX.setText("Accelerometer is not supported");
            tvY.setText("Accelerometer is not supported");
            tvZ.setText("Accelerometer is not supported");
        }
        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mGyro != null) {
            sensorManager.registerListener(MainActivity.this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Gyro listener");
        } else {
            tvXGyro.setText("Gyro is not supported");
            tvYGyro.setText("Gyro is not supported");
            tvZGyro.setText("Gyro is not supported");
        }
        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mMagno != null) {
            sensorManager.registerListener(MainActivity.this, mMagno, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Magnometer listener");
        } else {
            tvXMagno.setText("Magno is not supported");
            tvYMagno.setText("Magno is not supported");
            tvZMagno.setText("Magno is not supported");
        }
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight != null) {
            sensorManager.registerListener(MainActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Light listener");
        } else {
            tvLight.setText("Light is not supported");
        }
        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (mTemp != null) {
            sensorManager.registerListener(MainActivity.this, mTemp, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Magnometer listener");
        } else {
            tvTemperature.setText("Temp is not supported");
        }
        mPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (mPressure != null) {
            sensorManager.registerListener(MainActivity.this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Pressure listener");
        } else {
            tvPressure.setText("Pressure is not supported");
        }

        mHumidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (mHumidity != null) {
            sensorManager.registerListener(MainActivity.this, mHumidity, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Humidity listener");
        } else {
            tvHumidity.setText("Humidity is not supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            Log.d(TAG, "onSensorChanged:  X:" + sensorEvent.values[0] + "Y:" + sensorEvent.values[1] + "Z:" + sensorEvent.values[2]);
            tvX.setText("X:" + sensorEvent.values[0]);
            tvY.setText("Y:" + sensorEvent.values[1]);
            tvZ.setText("Z:" + sensorEvent.values[2]);
        } else if (sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            Log.d(TAG, "onSensorChanged:  X:" + sensorEvent.values[0] + "Y:" + sensorEvent.values[1] + "Z:" + sensorEvent.values[2]);
            tvXGyro.setText("X:" + sensorEvent.values[0]);
            tvYGyro.setText("Y:" + sensorEvent.values[1]);
            tvZGyro.setText("Z:" + sensorEvent.values[2]);
        } else if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            Log.d(TAG, "onSensorChanged:  X:" + sensorEvent.values[0] + "Y:" + sensorEvent.values[1] + "Z:" + sensorEvent.values[2]);
            tvXMagno.setText("X:" + sensorEvent.values[0]);
            tvYMagno.setText("Y:" + sensorEvent.values[1]);
            tvZMagno.setText("Z:" + sensorEvent.values[2]);
        } else if (sensor.getType() == Sensor.TYPE_LIGHT) {
            Log.d(TAG, "onSensorChanged:  X:" + sensorEvent.values[0]);
            tvLight.setText("Light:" + sensorEvent.values[0]);
        } else if (sensor.getType() == Sensor.TYPE_PRESSURE) {
            Log.d(TAG, "onSensorChanged:  X:" + sensorEvent.values[0]);
            tvPressure.setText("Presure:" + sensorEvent.values[0]);
        } else if (sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
            Log.d(TAG, "onSensorChanged:  X:" + sensorEvent.values[0]);
            tvHumidity.setText("Humidity:" + sensorEvent.values[0]);
        } else if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            Log.d(TAG, "onSensorChanged:  X:" + sensorEvent.values[0]);
            tvTemperature.setText("Temperature:" + sensorEvent.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
