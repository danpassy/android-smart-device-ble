package fr.isen.boussougou.androidsmartdevice.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceScreen(
    name: String,
    address: String,
    rssi: Int,
    onBack: () -> Unit,
    onConnectClick: () -> Unit,
    connectionStatus: String,
    isConnected: Boolean,
    ledStates: List<Boolean>,
    onLedToggle: (Int) -> Unit,
    isSubscribedButton1: Boolean,
    isSubscribedButton3: Boolean,
    onSubscribeToggleButton1: (Boolean) -> Unit,
    onSubscribeToggleButton3: (Boolean) -> Unit,
    counterButton1: Int,
    counterButton3: Int,
    onResetCounter: () -> Unit
) {
    val ledColors = listOf(
        Color(0xFF00897B), // LED 1
        Color(0xFF42A5F5), // LED 2
        Color(0xFFF44336)  // LED 3
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Détails du périphérique",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Retour", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00897B), // Teal color to match the theme
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            if (!isConnected) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1)), // Light teal background
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text("Appareil détecté", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00695C))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Nom : $name", fontSize = 16.sp)
                        Text("Adresse : $address", fontSize = 14.sp, color = Color.Gray)
                        Text("RSSI : $rssi dBm", fontSize = 14.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(connectionStatus, fontSize = 14.sp, color = if (isConnected) Color.Green else Color(0xFF00695C))
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
            }

            Button(
                onClick = onConnectClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00897B)) // Teal button color
            ) {
                Text(if (isConnected) "Déconnecter" else "Se connecter", color = Color.White, fontSize = 16.sp)
            }

            if (isConnected) {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    "Contrôlez les LEDs ci-dessous:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00897B), // Teal color
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Row(
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ledStates.forEachIndexed { index, isOn ->
                        val color = ledColors[index] // Color based on the state
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Button(
                                onClick = { onLedToggle(index) },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isOn) color else Color.LightGray
                                ),
                                modifier = Modifier
                                    .height(64.dp)
                                    .width(100.dp)
                            ) {
                                Text("LED ${index + 1}", color = Color.White, maxLines = 1)
                            }
                        }
                    }
                }

                Divider(modifier = Modifier.padding(vertical = 16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isSubscribedButton3,
                        onCheckedChange = { onSubscribeToggleButton3(it) }
                    )
                    Text("Recevoir les notifications de bouton 1")
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isSubscribedButton1,
                        onCheckedChange = { onSubscribeToggleButton1(it) }
                    )
                    Text("Recevoir les notifications de bouton 3")
                }

                Spacer(modifier = Modifier.height(24.dp))
                Text("Compteur bouton 1 : $counterButton3", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Compteur bouton 3 : $counterButton1", fontSize = 16.sp)

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onResetCounter,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF42A5F5))
                ) {
                    Text("Réinitialiser les compteurs")
                }
            }
        }
    }
}
