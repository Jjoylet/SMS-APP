package com.joylet.smsapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
      //  TODO("SmsReceiver.onReceive() is not implemented")
        if (!intent.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)){
            return
        }
        val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)

        smsMessages.forEach {
            val sms = it.displayMessageBody
            val sender = it.displayOriginatingAddress
            Toast.makeText(context,"$sender : $sms",Toast.LENGTH_SHORT).show()

            Log.d("MESSAGE_RECEIVED",it.displayMessageBody)
            Log.d("MESSAGE_RECEIVED",it.displayOriginatingAddress)

            if (it.originatingAddress.equals("0711437990") || it.displayMessageBody.contains("fuck"))
            {
                abortBroadcast()//stopping the sms from going into the inbox
            }

        }
    }
}