package edu.washington.lpa2.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtons()

    }

    private fun updateLife(player: String, op: String, dmg: Int) {
        if (player_lost.text != "") {
            return
        }
        val pid = when (player) {
            "p1" -> R.id.p1_hp
            "p2" -> R.id.p2_hp
            "p3" -> R.id.p3_hp
            "p4" -> R.id.p4_hp
            else -> return
        }
        val pc = findViewById<TextView>(pid)
        val hp = when (op) {
            "+" -> pc.text.toString().toInt() + dmg
            "-" -> pc.text.toString().toInt() - dmg
            else -> pc.text.toString().toInt()
        }
        if (hp <= 0) {
            val lostMsg = "$player is the loser!"
            player_lost.text = lostMsg
        }
        pc.text = hp.toString()
    }

    private fun setButtons() {
        p1_minus5.setOnClickListener {_ -> updateLife("p1", "-", 5)}
        p1_minus1.setOnClickListener {_ -> updateLife("p1", "-", 1)}
        p1_plus1.setOnClickListener {_ -> updateLife("p1", "+", 1)}
        p1_plus5.setOnClickListener {_ -> updateLife("p1", "+", 5)}

        p2_minus5.setOnClickListener {_ -> updateLife("p2", "-", 5)}
        p2_minus1.setOnClickListener {_ -> updateLife("p2", "-", 1)}
        p2_plus1.setOnClickListener {_ -> updateLife("p2", "+", 1)}
        p2_plus5.setOnClickListener {_ -> updateLife("p2", "+", 5)}

        p3_minus5.setOnClickListener {_ -> updateLife("p3", "-", 5)}
        p3_minus1.setOnClickListener {_ -> updateLife("p3", "-", 1)}
        p3_plus1.setOnClickListener {_ -> updateLife("p3", "+", 1)}
        p3_plus5.setOnClickListener {_ -> updateLife("p3", "+", 5)}

        p4_minus5.setOnClickListener {_ -> updateLife("p4", "-", 5)}
        p4_minus1.setOnClickListener {_ -> updateLife("p4", "-", 1)}
        p4_plus1.setOnClickListener {_ -> updateLife("p4", "+", 1)}
        p4_plus5.setOnClickListener {_ -> updateLife("p4", "+", 5)}
    }
}
