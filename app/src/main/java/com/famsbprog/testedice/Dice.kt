package com.famsbprog.testedice

class Dice(var numSides: Int)
{

    fun roll(): Int
    {
        return (1..numSides).random()
    }
}//End Class Dice}