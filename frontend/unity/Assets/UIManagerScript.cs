using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.UI;




public class UIManagerScript : MonoBehaviour
{
    public TMP_Text statsText;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }


    public void moveCardIn(GameObject uiElement)
    {
        LeanTween.moveLocalX(uiElement, 720, 5.0f * Time.deltaTime);
       

    }

    public void setCardStats(string text)
    {
        statsText.text = text.ToString();
    }

    public void moveCardOut(GameObject uiElement)
    {
        LeanTween.moveLocalX(uiElement, 1295, 5.0f *  Time.deltaTime);
    }
}
