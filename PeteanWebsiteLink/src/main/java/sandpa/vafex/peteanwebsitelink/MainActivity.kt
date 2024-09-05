package sandpa.vafex.peteanwebsitelink
/*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://sites.google.com/view/peteanautodidactic52/home")
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
    }
}*/
/*
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private var countdownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        startTimer()
    }

    private fun startTimer() {
        // Set the time in milliseconds (e.g., 10 seconds)
        val totalTimeInMillis: Long = 10000

        // Set the interval for countdown (e.g., 1 second)
        val intervalInMillis: Long = 1000

        countdownTimer = object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
            override fun onTick(millisUntilFinished: Long) {
                // You can update UI here if you want to show the countdown (optional)
            }

            override fun onFinish() {
                // Open the website after the countdown finishes
                openWebsite()
            }
        }

        countdownTimer?.start()
    }

    private fun openWebsite() {
        // Replace "https://sites.google.com/view/peteanautodidactic52/home" with your actual website URL
        val websiteUri = Uri.parse("https://sites.google.com/view/peteanautodidactic52/home")
        val intent = Intent(Intent.ACTION_VIEW, websiteUri)
        startActivity(intent)
        finish() // Finish the activity after opening the website
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancel the countdown timer to avoid memory leaks
        countdownTimer?.cancel()
    }
}
*/

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var timerTextView: TextView
    private var countdownTimer: CountDownTimer? = null
    private val totalTimeInMillis: Long = 5000 // Total time in milliseconds (e.g., 10 seconds)
    private val intervalInMillis: Long = 1000 // Interval for countdown (e.g., 1 second)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        timerTextView = findViewById(R.id.timerTextView)

        startTimer()
    }

    private fun startTimer() {
        countdownTimer = object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerTextView.text = "Timer: $secondsRemaining seconds"
            }

            override fun onFinish() {
                openWebsite()
            }
        }

        countdownTimer?.start()
    }

    private fun openWebsite() {
        // Replace "https://sites.google.com/view/peteanautodidactic52/home" with your actual website URL
        val websiteUri = Uri.parse("https://sites.google.com/view/peteanautodidactic52/home")
        val intent = Intent(Intent.ACTION_VIEW, websiteUri)
        startActivity(intent)
        finish() // Finish the activity after opening the website
    }

    override fun onDestroy() {
        super.onDestroy()
        countdownTimer?.cancel()
    }
}

/*

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var timerTextView: TextView
    private lateinit var textView: TextView
    private var countdownTimer: CountDownTimer? = null
    private val totalTimeInMillis: Long = 5000 // Total time in milliseconds (e.g., 10 seconds)
    private val intervalInMillis: Long = 1000 // Interval for countdown (e.g., 1 second)
    private val delayInMillis: Long = 1000 // Delay before starting countdown timer (e.g., 1 second)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        timerTextView = findViewById(R.id.timerTextView)
        textView = findViewById(R.id.textView)

        startTimerWithDelay()
    }

    private fun startTimerWithDelay() {
        // Delay before starting countdown timer
        object : CountDownTimer(delayInMillis, delayInMillis) {
            override fun onTick(millisUntilFinished: Long) {
                // Do nothing
            }

            override fun onFinish() {
                startTimer()
            }
        }.start()
    }

    private fun startTimer() {
        countdownTimer = object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerTextView.text = "Timer: $secondsRemaining seconds"
            }

            override fun onFinish() {
                openWebsite()
            }
        }

        countdownTimer?.start()
    }

    private fun openWebsite() {
        // Replace "https://sites.google.com/view/peteanautodidactic52/home" with your actual website URL
        val websiteUri = Uri.parse("https://sites.google.com/view/peteanautodidactic52/home")
        val intent = Intent(Intent.ACTION_VIEW, websiteUri)
        startActivity(intent)
        finish() // Finish the activity after opening the website
    }

    override fun onDestroy() {
        super.onDestroy()
        countdownTimer?.cancel()
    }
}

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var timerTextView: TextView
    private lateinit var textView: TextView
    private var countdownTimer: CountDownTimer? = null
    private val totalTimeInMillis: Long = 5000 // Total time in milliseconds (e.g., 10 seconds)
    private val intervalInMillis: Long = 1000 // Interval for countdown (e.g., 1 second)
    private val delayInMillis: Long = 1000 // Delay before starting countdown timer (e.g., 1 second)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        timerTextView = findViewById(R.id.timerTextView)
        textView = findViewById(R.id.textView)

        startTimerWithDelay()
    }

    private fun startTimerWithDelay() {
        // Delay before starting countdown timer
        object : CountDownTimer(delayInMillis, delayInMillis) {
            override fun onTick(millisUntilFinished: Long) {
                // Do nothing
            }

            override fun onFinish() {
                startTimer()
            }
        }.start()
    }

    private fun startTimer() {
        countdownTimer = object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerTextView.text = "Timer: $secondsRemaining seconds"
            }

            override fun onFinish() {
                openWebsite()
            }
        }

        countdownTimer?.start()
    }

    private fun openWebsite() {
        // Replace "https://sites.google.com/view/peteanautodidactic52/home" with your actual website URL
        val websiteUri = Uri.parse("https://sites.google.com/view/peteanautodidactic52/home")
        val intent = Intent(Intent.ACTION_VIEW, websiteUri)
        startActivity(intent)
        finish() // Finish the activity after opening the website
    }

    override fun onDestroy() {
        super.onDestroy()
        countdownTimer?.cancel()
    }

    private fun changeBackgroundColor(color: Int) {
        textView.setBackgroundColor(color)
    }

    // Call this method with the desired color after the delay
    private fun executeColorChange() {
        // Change background color to red (you can replace with Color.YELLOW or Color.BLUE)
        changeBackgroundColor(Color.RED)
    }
}
*/
