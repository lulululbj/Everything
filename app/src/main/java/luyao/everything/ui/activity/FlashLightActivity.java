package luyao.everything.ui.activity;


import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.view.View;

import butterknife.OnClick;
import luyao.everything.R;
import luyao.everything.base.BaseActivity;

/**
 * Created by Lu
 * on 2017/04/11 17:24
 */

public class FlashLightActivity extends BaseActivity {

    private Camera camera;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_flash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.flashlight_bt)
    public void onClick(View v) {
        turnOnFlashLight();
    }

    @OnClick(R.id.flashlight_close)
    public void onClickClose(View v) {
        turnOffFlashLight();
    }

    public boolean turnOnFlashLight() {
        if (camera == null) {
            camera = Camera.open();
            camera.startPreview();
            Camera.Parameters parameter = camera.getParameters();
            parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameter);
        }
        return true;
    }

    public boolean turnOffFlashLight() {
        if (camera != null) {
            Camera.Parameters parameter = camera.getParameters();
            parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameter);
            camera.stopPreview();
            camera.release();
            camera = null;
        }
        return true;
    }
}
