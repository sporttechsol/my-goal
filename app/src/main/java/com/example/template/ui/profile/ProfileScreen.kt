package com.example.template.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.template.ui.login.LoginViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    Column(modifier = Modifier.verticalScroll(state = rememberScrollState())) {
        Column(horizontalAlignment = CenterHorizontally) {
            TopAppBar(title = {
                Text(text = "My Profile")
            })

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = rememberImagePainter(
                    data = state.value.user.avatarUrl,
//                    data = "https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg",
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(218.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = state.value.user.name,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Achievements",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Achievement(
                title = "Running 30m",
                result = "14 sec",
                progress = 0.3f
            )

            Achievement(
                title = "Running 100m",
                result = "62 sec",
                progress = 0.5f
            )

            Achievement(
                title = "Pass",
                result = "17 %",
                progress = 0.2f
            )

            Achievement(
                title = "Dribbling",
                result = "22 %",
                progress = 0.3f
            )

            Achievement(
                title = "Hitting accuracy",
                result = "12 %",
                progress = 0.1f
            )

            Achievement(
                title = "Endurance",
                result = "14 %",
                progress = 0.25f
            )

            Achievement(
                title = "Hit",
                result = "24 %",
                progress = 0.4f
            )

            Text(
                text = "Personal details",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            PersonalDetail(title = "Age", value = "${state.value.user.age} years")
            PersonalDetail(title = "City", value = state.value.user.location)
            PersonalDetail(title = "Email", value = state.value.user.email)

            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}
