using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting.Antlr3.Runtime.Misc;
using UnityEngine;

[System.Serializable]
public class townHallStats
{
    public int villageCount;
    public int soldierCount;
    public int farmerCount;
    public int minerCount;
    public int foodGatherCount;
    public int goldGaterCount;
}

public class TownHallA_Script : MonoBehaviour
{

    UIManagerScript uiManager;

    public GameObject uiCard;
    public townHallStats TownHallAStats;

    // Start is called before the first frame update
    void Start()
    {
        uiManager = FindFirstObjectByType<UIManagerScript>();
    }

    // Update is called once per frame
    void Update()
    {
       
    }

    void OnMouseDown()
    {
      

        uiManager.moveCardIn(uiCard);


        var stats = TownHallAStats;

        uiManager.setCardStats($"Villager Count: {stats.villageCount} <br>" +
        $"Soldier Count: {stats.soldierCount} <br>" +
               $"Farmer Count: {stats.farmerCount} <br>" +
               $"Miner Count: {stats.minerCount} <br>" +
               $"Food Gatherer Count: {stats.foodGatherCount} <br>" +
               $"Gold Gatherer Count: {stats.goldGaterCount}");

        // Add your custom logic here
    }
}
