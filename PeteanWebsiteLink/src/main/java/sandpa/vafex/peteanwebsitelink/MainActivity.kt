//Acest cod transformă aplicația asta într-un fel de "iconita de acces" (splash screen cu
//cronometru) care, după 5 secunde, te trimite automat către browserul telefonului pentru
//a vedea site-ul, gazduit pe Google Sites.Creat pe Google Drive
//Google Drive nu mai permite oficial găzduirea de pagini web HTML direct
//(serviciul a fost închis acum câțiva ani).
//Totuși, link-ul este de Google Sites, funcțional, pe telefonul meu!
//Ca-n gluma aia :_Functioneaza pe laptopul meu !_Nu putem sa dam laptopul tau clientului !

package sandpa.vafex.peteanwebsitelink

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
    //Referință pentru un mini-browser intern (deși în final nu îl folosesc pentru afișare).
    private lateinit var webView: WebView
    //Se scurg secundele
    private lateinit var timerTextView: TextView
    //Obiectul ce face numaratoarea inversa
    private var countdownTimer: CountDownTimer? = null
    //Tmpul total de asteptare: 5 sec
    private val totalTimeInMillis: Long = 5000
    //Secunda se scade la fiecare 1000 ms
    private val intervalInMillis: Long = 1000

    //se incarca design-ul (Layout-ul)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //configureaza WebView (mini browserul intern)
        webView = findViewById(R.id.webView)
        //spune app, sa deschida link-urile in interior, nu in browser (teoretic)
        webView.webViewClient = WebViewClient()
        //activeaza JavaScript (necesar pentru Google Sites)
        webView.settings.javaScriptEnabled = true
        //permite marirea textului cu degetele
        webView.settings.setSupportZoom(true)

        //identifica textul pentru cronometru
        timerTextView = findViewById(R.id.timerTextView)

        //porneste numaratoarea inversa
        startTimer()
    }
    //logica cronometrului (startTimer) om
    private fun startTimer() {
        countdownTimer = object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
            //se executa la fiecare secunda
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerTextView.text = "Timer: $secondsRemaining seconds"
            }
            //se execută când s-au terminat cele 5 secunde
            override fun onFinish() {
            //lansarea website-ului
                openWebsite()
            }
        }
        //pornirea cronometrului
        countdownTimer?.start()
    }

    private fun openWebsite() {
        //Uri(Uniform Resource Identifier:site,nr.tel,locatieGPS).Parse()(String->UriObject)
        val websiteUri = Uri.parse("https://sites.google.com/view/peteanautodidactic52/home")
        //Intent:formular/cerere;intent:cerere completata.caSaVizualizez(ACTION_VIEW),
        //websiteUri(aceasta adresa specifica)
        val intent = Intent(Intent.ACTION_VIEW, websiteUri)
        //cine stie VIEW pentru un link?Chrome :_Eu;Opera:_Eu!
        //Execution: Dacă e un singur browser, se deschide automat. Dacă sunt mai multe,
        //apare acea fereastră mică jos: „Open with Chrome or Opera?”.
        startActivity(intent)
        finish() // Finish the activity after opening the website
    }

    override fun onDestroy() {
        super.onDestroy()
        countdownTimer?.cancel()
    }
}

