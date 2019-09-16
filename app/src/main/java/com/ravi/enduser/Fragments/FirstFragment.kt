package com.ravi.enduser.Fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.ravi.enduser.Activity.Login_Activity
import com.ravi.enduser.R

import android.widget.SimpleAdapter
import android.widget.ListView
import android.widget.Toast
import org.w3c.dom.CharacterData
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.xml.sax.InputSource
import org.xml.sax.SAXException
import java.io.IOException
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException




/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {
    var empDataHashMap = HashMap<String, String>()
    var empList: ArrayList<HashMap<String, String>> = ArrayList()
    var url = URL("https://www.bhaskar.com/rss-feed/2322")
    private var webView: WebView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View= inflater!!.inflate(R.layout.fragment_first, container, false)




        val lv = view.findViewById(R.id.listView) as ListView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            lv.setNestedScrollingEnabled(true)
        };
        // Using a background thread to do network code
        val thread = object : Thread() {
            override fun run() {
                try {
                    // Comment-out this line of code
                    // val istream = assets.open("empdetail.xml")
                    val builderFactory = DocumentBuilderFactory.newInstance()
                    builderFactory.setCoalescing(true);
                    val docBuilder = builderFactory.newDocumentBuilder()
                    val doc = docBuilder.parse(InputSource(url.openStream()))
                    // reading player tags
                    val nList = doc.getElementsByTagName("item")

                    for (i in 0 until nList.length) {
                        if (nList.item(0).nodeType.equals(Node.ELEMENT_NODE)) {
                            empDataHashMap = HashMap()
                            val element = nList.item(i) as Element

                            empDataHashMap.put("title", getNodeValue("title", element))
                            empDataHashMap.put("description", getNodeValue("pubDate", element))
                            empDataHashMap.put("link", getNodeValue("link", element))

                            empList.add(empDataHashMap)
                        }
                    }

                    val adapter = SimpleAdapter(
                            context,
                            empList,
                            R.layout.row_rss_item,
                            arrayOf("title", "description"),
                            intArrayOf(R.id.tvTitle, R.id.tvPubDate)
                    )

                    activity?.runOnUiThread {
                        lv.setAdapter(adapter)
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: ParserConfigurationException) {
                    e.printStackTrace()
                } catch (e: SAXException) {
                    e.printStackTrace()
                }
            }
        }

        thread.start()



//        webView = view.findViewById(R.id.webView) as WebView
//        webView!!.webViewClient = WebViewClient()
//        webView!!.settings.javaScriptEnabled = true
//        webView!!.setVerticalScrollBarEnabled(true)
//        webView!!.loadUrl("https://www.bhaskar.com/rss-feed/2322/")



        val button: CardView =view.findViewById(R.id.login)
        button.setOnClickListener {
            var intent = Intent(context, Login_Activity::class.java)
            startActivity(intent)
        }

        return view
    }
    //return node value
    public fun getNodeValue(tag: String, element: Element): String{
        val nodeList = element.getElementsByTagName(tag)
        val element1 :Element= nodeList.item(0) as Element

                var node:Node = element1.firstChild

while(node!=null) {
    if (node is CharacterData) {
        val cd: CharacterData = node
        Log.d("data_xml", Html.fromHtml(cd.getData()).toString());
        return Html.fromHtml(cd.getData()).toString()
    } }
        return ""
    }

}