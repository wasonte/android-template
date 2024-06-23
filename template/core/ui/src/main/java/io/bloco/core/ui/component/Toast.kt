package io.bloco.core.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource

@Composable
fun Toast(stringId: Int) {
    val context = LocalContext.current
    android.widget.Toast.makeText(
        context, stringResource(id = stringId), android.widget.Toast.LENGTH_LONG
    ).show()
}
