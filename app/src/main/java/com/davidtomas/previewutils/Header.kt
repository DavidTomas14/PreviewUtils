package com.davidtomas.previewutils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.davidtomas.previewutils.ui.theme.PreviewUtilsTheme

@Composable
fun Header(
    modifier: Modifier = Modifier,
    headerText: String = "",
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    leadingComposable: @Composable (() -> Unit)? = {},
    trailingComposable: @Composable (() -> Unit)? = {},
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        leadingComposable?.let { it() }
        Text(
            modifier = Modifier
                .weight(1f),
            textAlign = TextAlign.Center,
            style = textStyle,
            color = textColor,
            text = headerText
        )
        trailingComposable?.let { it() }
    }
}

class PreviewParameters(
    val text: String,
    val leadingIcon: ImageVector,
    val trailingIcon: ImageVector
)

class PreviewParametersProvider : PreviewParameterProvider<PreviewParameters> {
    override val values: Sequence<PreviewParameters>
        get() = sequenceOf(
            PreviewParameters(
                leadingIcon = Icons.AutoMirrored.Filled.ArrowBack,
                trailingIcon = Icons.AutoMirrored.Filled.Send,
                text = "Detail Screen"
            ),
            PreviewParameters(
                leadingIcon = Icons.Filled.Done,
                trailingIcon = Icons.Filled.Edit,
                text = "Home Screen"
            ),
            PreviewParameters(
                leadingIcon = Icons.Filled.Add,
                trailingIcon = Icons.Filled.Notifications,
                text = "Notifications Screen"
            )
        )
}


//@Preview
//@PreviewLightDark
//@PreviewFontScale
@PreviewScreenSizes
@Composable
fun HeaderPreview(
    @PreviewParameter(PreviewParametersProvider::class) previewParameters: PreviewParameters,
) {
    PreviewUtilsTheme {
        Header(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary),
            headerText = previewParameters.text,
            leadingComposable = {
                Icon(
                    imageVector = previewParameters.leadingIcon,
                    modifier = Modifier,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            },
            trailingComposable = {
                Icon(
                    imageVector = previewParameters.trailingIcon,
                    modifier = Modifier,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
    }
}