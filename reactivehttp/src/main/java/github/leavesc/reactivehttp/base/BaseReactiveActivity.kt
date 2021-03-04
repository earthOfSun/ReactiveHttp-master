package github.leavesc.reactivehttp.base

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import github.leavesc.reactivehttp.viewmodel.IUIActionEventObserver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

/**
 * @Author: leavesC
 * @Date: 2020/10/22 10:27
 * @Desc: BaseActivity
 * @GitHub：https://github.com/leavesC
 */
open abstract class BaseReactiveActivity : AppCompatActivity(), IUIActionEventObserver {

    override val lifecycleSupportedScope: CoroutineScope
        get() = lifecycleScope

    override val lContext: Context?
        get() = this

    override val lLifecycleOwner: LifecycleOwner
        get() = this





    override fun showToast(msg: String) {
        if (msg.isNotBlank()) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun finishView() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        dismissLoading()
    }

}