package com.example.tomandjerry

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.foundation.gestures.detectTapGestures
import kotlin.math.abs
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tomandjerry.ui.theme.TomAndJerryTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.math.absoluteValue

var globalYOne  =  mutableStateListOf<Int>(-50,-50,-50,-50,-50)
var globalYTwo  = mutableStateListOf<Int>(-100,-100,-100,-100,-100)
var globalYThree  = mutableStateListOf<Int>(-50,-50,-50,-50,-50)




var posOne by   mutableIntStateOf(100)
// -80
// for 1 and 3 pos is -50
// for 2 and 4 -30

var active by mutableIntStateOf(0)
var activeTwo by mutableIntStateOf(0)
var activeThree by mutableIntStateOf(0)
var activeFour by mutableIntStateOf(0)
var activeFive by mutableIntStateOf(0)
var activeSix by mutableIntStateOf(0)
var activeSeven by mutableIntStateOf(0)
var activeEight by mutableIntStateOf(0)
var activeNine by mutableIntStateOf(0)
var activeTen by mutableIntStateOf(0)


var jerryX by mutableIntStateOf(196)
var tomX by mutableIntStateOf(195)
var tomY by mutableIntStateOf(810)
var hit by mutableStateOf(false )

var cheeseCount by mutableIntStateOf(0)
var bulletCount by mutableIntStateOf(0)






var called by mutableStateOf(false)
var calledOne by mutableStateOf(false)
var calledTwo by mutableStateOf(false)
var calledThree by mutableStateOf(false)
var calledFour by mutableStateOf(false)



var hitCount by mutableIntStateOf(0)
var collision by mutableStateOf(false)
var gameOver by mutableStateOf(false)

var jerrySize by mutableIntStateOf(20)

var trapValue = -1




val possibility  = ((110..200) step 1).toList()

var turn = false
var speed  by mutableIntStateOf(4)

var jumpUp by mutableStateOf(false)
var jumpDown by mutableStateOf(false)
var jerryOnAir by mutableStateOf(false)

var bulletStart by mutableStateOf(false)
var bulletHit by mutableStateOf(false)

var trapActivate by mutableStateOf(false)



var trapCall = mutableStateListOf<Boolean>(true,true,true)




var posTwo by   mutableIntStateOf(280)

var bulletY by   mutableIntStateOf(590)
var bulletX by   mutableIntStateOf(194)




var finalDistanceTwo = 1800
var distanceTraversed by  mutableDoubleStateOf(0.0)


var stateOne  = mutableStateListOf<Boolean>(false,false,false,false,false)
var stateTwo  = mutableStateListOf<Boolean>(false,false,false,false)
var stateThree  = mutableStateListOf<Boolean>(false,false,false,false,false)

var caught  = mutableStateListOf<Boolean>(false,false,false,false,false,false)

var boxHitOne = mutableStateListOf<Boolean>(false,false,false,false,false)
var boxHitTwo = mutableStateListOf<Boolean>(false,false,false,false,false)
var boxHitThree = mutableStateListOf<Boolean>(false,false,false,false,false)


val customBlue = Color(0xFF2B82EB)
val gridColor = Color(0xFFE5DCCD)
val brown = Color(0xFF5F342B)
val backColor = Color(0xFFF8EFDE)
val tomColor = Color(0xFF515151)

var globalColorOne  =  mutableStateListOf<Color>(customBlue,customBlue,customBlue, customBlue,
    customBlue)

var globalColorTwo  =  mutableStateListOf<Color>(customBlue,customBlue,customBlue, customBlue,
    customBlue)

var globalColorThree  =  mutableStateListOf<Color>(customBlue,customBlue,customBlue, customBlue,
    customBlue)


var cheese = mutableStateListOf<Int>(-100,-100,-100,-100,-100,-100)

var trapSet = mutableStateListOf<Int>(0,0,0)


var cheeseCall = mutableStateListOf<Boolean>(false,false,false,false,false,false)
var cheeseState = mutableStateListOf<Boolean>(false,false,false,false,false,false)
var cheeseChecked= mutableStateListOf<Boolean>(false,false,false,false,false,false)
var cheesePos  = mutableStateListOf<Int>(0,0,0,0,0,0)
var high = mutableStateListOf<Boolean>(false,false,false,false,false,false)




var overlap = mutableStateListOf<Boolean>(false,false,false,false,false,false)





class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Log.d("Cheeese",cheeseCount.toString())



            Box(
                modifier = Modifier.fillMaxSize()
                .background(color = backColor)
            )
            {
                GreyGrid()
                if(!gameOver)
                {
                    Parallax()
                    CheeseMaker()
                }
                else
                {
                    tomX = jerryX-1
                }



                Square(50,globalYOne[0],globalColorOne[0])
                Square(50,globalYOne[1],globalColorOne[1])
                Square(50,globalYOne[2],globalColorOne[2])
                Square(50,globalYOne[3],globalColorOne[3])
                Square(50,globalYOne[4],globalColorOne[4])

                // second column
                Square(175,globalYTwo[0],globalColorTwo[0])
                Square(175,globalYTwo[1],globalColorTwo[1])
                Square(175,globalYTwo[2],globalColorTwo[2])
                Square(175,globalYTwo[3],globalColorTwo[3])
                Square(175,globalYTwo[4],globalColorTwo[4])

                // third column
                Square(300,globalYThree[0],globalColorThree[0])
                Square(300,globalYThree[1], globalColorThree[1])
                Square(300,globalYThree[2], globalColorThree[2])
                Square(300,globalYThree[3], globalColorThree[3])
                Square(300,globalYThree[4], globalColorThree[4])

                // cheese set 1 column 2
                SquareTrap(if(!high[0])182 else 180, cheese[0], Color.Yellow,caught[0],high[0])
                SquareTrap(if(!high[1])182 else 180, cheese[1], Color.Yellow,caught[1],high[1])

                // cheese set 1 column 1

                SquareTrap(if(!high[2])57 else 55, cheese[2], Color.Yellow,caught[2],high[2])
                SquareTrap(if(!high[3])57 else 55, cheese[3], Color.Yellow, caught[3],high[3])

                // cheese set 1 column 3

                SquareTrap(if(!high[4])307 else 305, cheese[4], Color.Yellow, caught[4],high[4])
                SquareTrap(if (!high[5])307 else 305, cheese[5], Color.Yellow, caught[5],high[5])


                speedIncreaser()

                trapActivator()



                TrapSetter()

                CheeseChecker()

                // centercheck

//                circle(70,squareCenterOne[0],3,Color.Black)
//                circle(70,squareCenterOne[1],3,Color.Black)
//                circle(70,cheeseCenter[2],3,Color.Black)
//                circle(70,cheeseCenter[3],3,Color.Black)
//                circle(70,squareCenterOne[4],3,Color.Black)

//                circle(40,squareCenterOne[0],3,Color.Green)
//                circle(40,squareCenterOne[1],3,Color.Green)
//                circle(40,squareCenterOne[2],3,Color.Green)
//                circle(40,squareCenterOne[3],3,Color.Green)
//                circle(40,squareCenterOne[4],3,Color.Green)
//                circle(150, bulletY,3,Color.Green)




                bulletMaker()

//           bullet
                Bullet(bulletX,bulletY, bulletHit)


                collisionChecker()

                bullet()

//                DrawHorizontalLine()

//           Jerry
                circle(jerryX,600,jerrySize,brown)

//           Tom
                circle(tomX,tomY,30,tomColor)








            }

            tomCheck()

            SwipeableBox()

            ScoreDisplay()

        }
    }
}

fun trapActivator()
{
    if(trapActivate)
    {
        trapValue = rand(listOf(0,1,2))
        trapActivate = false
    }

    if(trapValue == 0)
    {
        gameOver = true
        trapValue = -1
    }
    if( trapValue == 1 && tomY != 750)
    {
        var tomRandPos = (760..790 step 5).toMutableList()
        tomY = rand(tomRandPos)
        tomRandPos.remove(tomY)
        trapValue = -1
    }
    else if(trapValue == 1 && tomY == 750)
    {
        trapValue = rand(listOf(0,2))
    }
    if( trapValue == 2)
    {
        if(jerryX == 71)
        {
            if (rand(listOf(0,1)) == 1)
            {
                jerryX = 196
                bulletX = 194
            }
            else
            {
                jerryX = 321
                bulletX = 319

            }
        }
        else if(jerryX == 196)
        {
            if (rand(listOf(0,1)) == 1)
            {
                jerryX = 71
                bulletX = 69
            }
            else
            {
                jerryX = 321
                bulletX = 319

            }
        }
        if(jerryX == 321)
        {
            if (rand(listOf(0,1)) == 1)
            {
                jerryX = 196
                bulletX = 194
            }
            else
            {
                jerryX = 71
                bulletX = 69
            }
        }
        trapValue = -1
    }

    Log.d("trap",trapValue.toString())

}

@Composable
fun ScoreDisplay()
{
    Box(
        modifier = Modifier
            .width(350.dp)
            .height(50.dp)
            .offset(20.dp,30.dp)
            .background(Color.Black.copy(alpha = 0.5f),shape = RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center
    )
    {

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(text = "POINT",color = Color.White , fontSize = 25.sp, fontWeight = FontWeight.Bold  )
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = distanceTraversed.toInt().toString(),color = Color.White , fontSize = 25.sp, fontWeight = FontWeight.Bold  )
            Spacer(modifier = Modifier.width(20.dp))
            Box(modifier = Modifier
                .height(25.dp)
                .width(10.dp)
                .background(color = Color.Gray.copy(alpha = 0.5f))
                .border(width = 2.dp, color = Color.Black)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = bulletCount.toString(),color = Color.White , fontSize = 25.sp, fontWeight = FontWeight.Bold  )
            Spacer(modifier = Modifier.width(20.dp))
            Box(modifier = Modifier
                .size(25.dp)
                .background(color = Color.Yellow.copy(alpha = 0.5f))
                .border(width = 2.dp, color = Color.Black)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = cheeseCount.toString(),color = Color.White , fontSize = 25.sp, fontWeight = FontWeight.Bold  )
        }



    }
}

@Composable
fun bulletMaker()
{
    if(cheeseCount >= 5 && bulletCount<5 )
    {
        bulletCount += cheeseCount/5
        cheeseCount = cheeseCount%5
    }
}



@Composable
fun speedIncreaser()
{
    LaunchedEffect(gameOver) {
        while(!gameOver)
        {
            distanceTraversed += (speed * 0.1)
            delay(16L)
        }

    }

    if(distanceTraversed > 0 && distanceTraversed < 1000 )
    {
        speed = 4
    }
    else if(distanceTraversed > 1000 && distanceTraversed < 3000 )
    {
        speed = 5
    }
    else if(distanceTraversed > 3000 && distanceTraversed < 6000 )
    {
        speed = 6
    }
    else if(distanceTraversed > 6000 && distanceTraversed < 10000 )
    {
        speed = 7
    }

    else if(distanceTraversed > 10000 && distanceTraversed < 20000 )
    {
        speed = 8
    }




}

@Composable
fun bullet()
{
    val squareCenterTwo = globalYTwo.map { it + 21 }
    val squareCenterThree = globalYThree.map { it + 21 }
    val squareCenterOne =  globalYOne.map { it + 21 }



    if(bulletStart)
    {
        if(bulletCount > 0)
        {
            LaunchedEffect(bulletY) {
                while(bulletY >= 0) {
                    withFrameNanos {
                        bulletY -= speed+5
                    }
                    delay(16L)
                }

            }
        }

    }
    if(bulletX == 194)
    {
        for(e in 0..4)
        {
            if((bulletY in squareCenterTwo[e]-21..squareCenterTwo[e])  && (bulletY in 0..580 ) )
            {
                bulletStart = false
                globalColorTwo[e] = Color.Transparent
                bulletHit = true
            }
        }

    }

    if(bulletX == 69)
    {
        for(f in 0..4)
        {
            if((bulletY in squareCenterOne[f]-21..squareCenterOne[f])  && (bulletY in 0..580 ) )
            {
                bulletStart = false
                globalColorOne[f] = Color.Transparent
                bulletHit = true
            }
        }

    }

    if(bulletX == 319)
    {
        for(w in 0..4)
        {
            if((bulletY in squareCenterThree[w]-21..squareCenterThree[w])  && (bulletY in 0..580 ) )
            {
                bulletStart = false
                globalColorThree[w]= Color.Transparent
                bulletHit = true
            }
        }

    }

    if(bulletHit)
    {
        bulletY = 590
        bulletHit = false
        bulletCount -= 1
    }


}


@Composable
fun CheeseChecker()
{

    val squareCenterTwo = globalYTwo.map { it + 21 }
    val squareCenterThree = globalYThree.map { it + 21 }
    val squareCenterOne =  globalYOne.map { it + 21 }
    val cheeseCenter = cheese.map { it + 13  }

    val threshold = 50


        for (i in 0..4)
        {
            if((cheeseCenter[0] in squareCenterTwo[i]-21.. squareCenterTwo[i]+21 step 1 ) &&  (cheeseCenter[0] > 5 && cheeseCenter[0]< 802 ))
            {
                if(globalColorTwo[i] != Color.Transparent)
                {
                    high[0] = true
                    overlap[0] = true
                }
                else
                {
                    high[0] = false
                    overlap[0] = false
                }

            }

            if((cheeseCenter[1] in squareCenterTwo[i]-21.. squareCenterTwo[i]+21 step 1) && (cheeseCenter[1] > 5 && cheeseCenter[1]< 802 ))

            {

                if(globalColorTwo[i] != Color.Transparent)
                {
                    high[1] = true
                    overlap[1] = true
                }
                else
                {
                    high[1] = false
                    overlap[1] = false
                }
            }

        }

    for (j in 0..4) {
        if((cheeseCenter[2] in squareCenterOne[j]-21.. squareCenterOne[j]+21 step 1 ) && (cheeseCenter[2] > 5 && cheeseCenter[2]< 802 ) )

        {

            if(globalColorOne[j] != Color.Transparent)
            {
                high[2] = true
                overlap[2] = true
            }
            else
            {
                high[2] = false
                overlap[2] = false
            }
        }

        if((cheeseCenter[3] in squareCenterOne[j]-21.. squareCenterOne[j]+21 step 1) && (cheeseCenter[3] > 5 && cheeseCenter[3]< 802 ) )
        {

            if(globalColorOne[j] != Color.Transparent)
            {
                high[3] = true
                overlap[3] = true
            }
            else
            {
                high[3] = false
                overlap[3] = false
            }
        }

    }



    for (k in 0..4) {
        if((cheeseCenter[4] in squareCenterThree[k]-21.. squareCenterThree[k]+21 step 1) && (cheeseCenter[4] > 5 && cheeseCenter[4]< 802 ) )
        {

            if(globalColorThree[k] != Color.Transparent)
            {
                high[4] = true
                overlap[4] = true
            }
            else
            {
                high[4] = false
                overlap[4] = false
            }
        }

        if((cheeseCenter[5] in squareCenterThree[k]-21..squareCenterThree[k]+21 step 1) && (cheeseCenter[5] > 0 && cheeseCenter[5]< 802 ) )
        {

            if(globalColorThree[k] != Color.Transparent)
            {
                high[5] = true
                overlap[5] = true
            }
            else
            {
                high[5] = false
                overlap[5] = false

            }
        }

    }



    if(jerryX == 196 )
    {
        if(overlap[0])
        {
            if(jerryOnAir)
            {
                if((cheeseCenter[0] >= 600 && cheeseCenter[0] <= 610) && !caught[0] )
                {
                    caught[0] = true
                    cheeseCount += 1
                }
            }
        }
        else
        {
            if(!jerryOnAir)
            {
                if((cheeseCenter[0] >= 600 && cheeseCenter[0] <= 610) && !caught[0] )
                {
                    caught[0] = true
                    cheeseCount += 1
                }
            }
        }


        // 2

        if(overlap[1])
        {
            if(jerryOnAir)
            {
                if((cheeseCenter[1] >= 600 && cheeseCenter[1] <= 610) &&   !caught[1] )
                {
                    caught[1] = true
                    cheeseCount += 1
                }
            }
        }
        else
        {
            if(!jerryOnAir)
            {
                if((cheeseCenter[1] >= 600 && cheeseCenter[1] <= 610) && !caught[1]    )
                {
                    caught[1] = true
                    cheeseCount += 1
                }
            }
        }
    }

    if(jerryX == 71 )
    {
        // 3

        if(overlap[2])
        {
            if(jerryOnAir)
            {
                if((cheeseCenter[2] >= 600 && cheeseCenter[2] <= 610) && !caught[2] )
                {
                    caught[2] = true
                    cheeseCount += 1
                }
            }
        }
        else
        {
            if(!jerryOnAir)
            {
                if((cheeseCenter[2] >= 600 && cheeseCenter[2] <= 610) && !caught[2]  )
                {
                    caught[2] = true
                    cheeseCount += 1
                }
            }
        }


        // 4

        if(overlap[3])
        {
            if(jerryOnAir)
            {
                if((cheeseCenter[3] >= 600 && cheeseCenter[3] <= 610) &&  !caught[3] )
                {
                    caught[3] = true
                    cheeseCount += 1
                }
            }
        }
        else
        {
            if(!jerryOnAir)
            {
                if((cheeseCenter[3] >= 600 && cheeseCenter[3] <= 610) &&  !caught[3] )
                {
                    caught[3] = true
                    cheeseCount += 1
                }
            }
        }
    }

    if(jerryX == 321 )
    {

        // 5

        if(overlap[4])
        {
            if(jerryOnAir)
            {
                if((cheeseCenter[4] >= 600 && cheeseCenter[4] <= 610) && !caught[4] )
                {
                    caught[4] = true
                    cheeseCount += 1
                }
            }
        }
        else
        {
            if(!jerryOnAir)
            {
                if((cheeseCenter[4] >= 600 && cheeseCenter[4] <= 610) &&  !caught[4] )
                {
                    caught[4] = true
                    cheeseCount += 1
                }
            }
        }


        // 6

        if(overlap[5])
        {
            if(jerryOnAir)
            {
                if((cheeseCenter[5] >= 600 && cheeseCenter[5] <= 610) &&  !caught[5] )
                {
                    caught[5] = true
                    cheeseCount += 1
                }
            }
        }
        else
        {
            if(!jerryOnAir)
            {
                if((cheeseCenter[5] >= 600 && cheeseCenter[5] <= 610) &&  !caught[5])
                {
                    caught[5] = true
                    cheeseCount += 1
                }
            }
        }
    }



}

fun TrapSetter()
{
    if(trapCall[0])
    {
        trapSet[0] = rand((0..4).toList())

        while(globalYOne[trapSet[0]] >=0 && globalYOne[trapSet[0]] <= 810)
        {
            trapSet[0] = rand((0..4).toList())
        }


        trapCall[0] = false
    }

    if(trapCall[1])
    {
        trapSet[1] = rand((0..4).toList())

        while(globalYTwo[trapSet[1]] >= 0 && globalYTwo[trapSet[1]] <= 810)
        {
            trapSet[1] = rand((0..4).toList())
        }

        trapCall[1] = false
    }

    if(trapCall[2])
    {
        trapSet[2] = rand((0..4).toList())

        while(globalYThree[trapSet[2]] >= 0 && globalYThree[trapSet[2]] <= 810)
        {
            trapSet[2] = rand((0..4).toList())
        }

        trapCall[2] = false
    }


    if(!trapCall[0])
    {
        globalColorOne[trapSet[0]] = Color.Green
    }
    if(!trapCall[1])
    {
        globalColorTwo[trapSet[1]] = Color.Green
    }
    if(!trapCall[2])
    {
        globalColorThree[trapSet[2]] = Color.Green
    }


    if(globalYOne[trapSet[0]] >  810)
    {
        trapCall[0] = true
    }

    if(globalYTwo[trapSet[1]] >  810)
    {
        trapCall[1] = true
    }

    if(globalYThree[trapSet[2]] >  810)
    {
        trapCall[2] = true
    }
}



@Composable
fun CheeseMaker()
{
    if(!cheeseCall[0])
    {
        cheesePos[0] = rand((-100..100).toList())
        cheeseCall[0] = true
    }


    if(!cheeseCall[1])
    {
        cheesePos[1] = rand((-100..100).toList())
        cheeseCall[1] = true
    }

    if(!cheeseCall[2])
    {
        cheesePos[2]  = rand((-100..100).toList())
        cheeseCall[2] = true
    }

    if(!cheeseCall[3])
    {
        cheesePos[3]  = rand((-100..100).toList())
        cheeseCall[3] = true
    }

    if(!cheeseCall[4])
    {
        cheesePos[4]  = rand((-100..100).toList())
        cheeseCall[4] = true
    }

    if(!cheeseCall[5])
    {
        cheesePos[5]  = rand((-100..100).toList())
        cheeseCall[5] = true
    }

// first set of cheese column - 2
    if((globalYTwo[0] > cheesePos[0] && globalYTwo[0] < cheesePos[0]+10)|| cheeseState[0])
    {

        LaunchedEffect(cheese[0]) {
            while(cheese[0] <= 810) {
                withFrameNanos {
                    cheese[0] += speed
                }
                delay(16L)
            }

        }

        cheeseState[0] = true

    }

    if((globalYTwo[2] > cheesePos[1] && globalYTwo[2] < cheesePos[1]+10)|| cheeseState[1])
    {

        LaunchedEffect(cheese[1]) {
            while(cheese[1] <= 810) {
                withFrameNanos {
                    cheese[1] += speed
                }
                delay(16L)
            }

        }

        cheeseState[1] = true

    }

    if((globalYTwo[1] > cheesePos[2] && globalYTwo[1] < cheesePos[2]+10)|| cheeseState[2])
    {

        LaunchedEffect(cheese[2]) {
            while(cheese[2] <= 810) {
                withFrameNanos {
                    cheese[2] += speed
                }
                delay(16L)
            }

        }

        cheeseState[2] = true

    }

    if((globalYTwo[3] > cheesePos[3] && globalYTwo[3] < cheesePos[3]+10)|| cheeseState[3])
    {

        LaunchedEffect(cheese[3]) {
            while(cheese[3] <= 810) {
                withFrameNanos {
                    cheese[3] += speed
                }
                delay(16L)
            }

        }

        cheeseState[3] = true

    }

    if((globalYTwo[2] > cheesePos[4] && globalYTwo[2] < cheesePos[4]+10)|| cheeseState[4])
    {

        LaunchedEffect(cheese[4]) {
            while(cheese[4] <= 810) {
                withFrameNanos {
                    cheese[4] += speed
                }
                delay(16L)
            }

        }

        cheeseState[4] = true

    }

    if((globalYTwo[4] > cheesePos[5] && globalYTwo[4] < cheesePos[5]+10)|| cheeseState[5])
    {

        LaunchedEffect(cheese[5]) {
            while(cheese[5] <= 810) {
                withFrameNanos {
                    cheese[5] += speed
                }
                delay(16L)
            }

        }

        cheeseState[5] = true

    }


    if(cheese[0] >= 810)
    {
        cheese[0] = -100
        cheeseState[0] = false
        caught[0] = false
        cheeseCall[0] = false
        overlap[0] = false
        high[0] = false
    }

    if(cheese[1] >= 810)
    {
        cheese[1] = -100
        cheeseState[1] = false
        caught[1] = false
        cheeseCall[1] = false
        overlap[1] = false
        high[1] = false

    }

    if(cheese[2] >= 810)
    {
        cheese[2] = -100
        cheeseState[2] = false
        caught[2] = false
        cheeseCall[2] = false
        overlap[2] = false
        high[2] = false

    }

    if(cheese[3] >= 810)
    {
        cheese[3] = -100
        cheeseState[3] = false
        caught[3] = false
        cheeseCall[3] = false
        overlap[3] = false
        high[3] = false

    }

    if(cheese[4] >= 810)
    {
        cheese[4] = -100
        cheeseState[4] = false
        caught[4] = false
        cheeseCall[4] = false
        overlap[4] = false
        high[4] = false

    }

    if(cheese[5] >= 810)
    {
        cheese[5] = -100
        cheeseState[5] = false
        caught[5] = false
        cheeseCall[5] = false
        overlap[5] = false
        high[5] = false

    }



}

@Composable
fun Parallax()
{




 //first
    if(!called) {
        active = rand(possibility)

        if(110 <= active && active < 120)
        {
            activeTwo = rand((190..200).toList())
        }
        else if(120 <= active && active < 130)
        {
            activeTwo = rand((180..190).toList())
        }
        else if(130 <= active && active < 140)
        {
            activeTwo = rand((170..180).toList())
        }
        else if(140 <= active && active < 150)
        {
            activeTwo = rand((160..170).toList())
        }
        else if (150 <= active && active < 160)
        {
            activeTwo = rand((150..160).toList())
        }
        else if(160 <= active && active < 170)
        {
            activeTwo = rand((140..150).toList())
        }
        else if(170 <= active && active < 180)
        {
            activeTwo = rand((130..140).toList())
        }
        else if(180 <= active && active < 190)
        {
            activeTwo = rand((120..130).toList())
        }
        else if(190 <= active && active < 200)
        {
            activeTwo = rand((110..120).toList())
        }


        called = true

    }

    // Two

    if(!calledOne)
    {
        activeThree = rand(possibility)

        if(110 <= activeThree && activeThree < 120)
        {
            activeFour = rand((190..200).toList())
        }
        else if(120 <= activeThree && activeThree < 130)
        {
            activeFour = rand((180..190).toList())
        }
        else if(130 <= activeThree && activeThree < 140)
        {
            activeFour = rand((170..180).toList())
        }
        else if(140 <= activeThree && activeThree < 150)
        {
            activeFour = rand((160..170).toList())
        }
        else if (150 <= activeThree && activeThree < 160)
        {
            activeFour = rand((150..160).toList())
        }
        else if(160 <= activeThree && activeThree < 170)
        {
            activeFour = rand((140..150).toList())
        }
        else if(170 <= activeThree && activeThree < 180)
        {
            activeFour = rand((130..140).toList())
        }
        else if(180 <= activeThree && activeThree < 190)
        {
            activeFour = rand((120..130).toList())
        }
        else if(190 <= activeThree && activeThree <= 200)
        {
            activeFour = rand((110..120).toList())
        }


        calledOne = true
    }

//    // three

    if(!calledTwo) {
        activeFive = rand(possibility)

        if(110 <= activeFive && activeFive < 120)
        {
            activeSix = rand((190..200).toList())
        }
        else if(120 <= activeFive && activeFive < 130)
        {
            activeSix = rand((180..190).toList())
        }
        else if(130 <= activeFive && activeFive < 140)
        {
            activeSix = rand((170..180).toList())
        }
        else if(140 <= activeFive && activeFive < 150)
        {
            activeSix = rand((160..170).toList())
        }
        else if (150 <= activeFive && activeFive <= 160)
        {
            activeSix = rand((150..160).toList())
        }
        else if(160 <= activeFive && activeFive < 170)
        {
            activeSix = rand((140..150).toList())
        }
        else if(170 <= activeFive && activeFive < 180)
        {
            activeSix= rand((130..140).toList())
        }
        else if(180 <= activeFive && activeFive < 190)
        {
            activeSix = rand((120..130).toList())
        }
        else if(190 <= activeFive && activeFive <= 200)
        {
            activeSix= rand((110..120).toList())
        }



        calledTwo = true

    }

    // four

    if(!calledThree) {
        activeSeven = rand(possibility)

        if(110 <= activeSeven && activeSeven < 120)
        {
            activeEight = rand((190..200).toList())
        }
        else if(120 <= activeSeven && activeSeven < 130)
        {
            activeEight = rand((180..190).toList())
        }
        else if(130 <= activeSeven && activeSeven < 140)
        {
            activeEight = rand((170..180).toList())
        }
        else if(140 <= activeSeven && activeSeven < 150)
        {
            activeEight = rand((160..170).toList())
        }
        else if (150 <= activeSeven && activeSeven < 160)
        {
            activeEight = rand((150..160).toList())
        }
        else if(160 <= activeSeven && activeSeven < 170)
        {
            activeEight = rand((140..150).toList())
        }
        else if(170 <= activeSeven && activeSeven < 180)
        {
            activeEight = rand((130..140).toList())
        }
        else if(180 <= activeSeven && activeSeven < 190)
        {
            activeEight = rand((120..130).toList())
        }
        else if(190 <= activeSeven && activeSeven <= 200)
        {
            activeEight = rand((110..120).toList())
        }


        calledThree= true

    }

    // five

    if(!calledFour)
    {
        activeNine = rand(possibility)


        if(110 <= activeNine && activeNine < 120)
        {
            activeTen= rand((190..200).toList())
        }
        else if(120 <= activeNine && activeNine < 130)
        {
            activeTen = rand((180..190).toList())
        }
        else if(130 <= activeNine && activeNine < 140)
        {
            activeTen= rand((170..180).toList())
        }
        else if(140 <= activeNine && activeNine < 150)
        {
            activeTen = rand((160..170).toList())
        }
        else if (150 <= activeNine && activeNine < 160)
        {
            activeTen = rand((150..160).toList())
        }
        else if(160 <= activeNine && activeNine < 170)
        {
            activeTen = rand((140..150).toList())
        }
        else if(170 <= activeNine && activeNine < 180)
        {
            activeTen= rand((130..140).toList())
        }
        else if(180 <= activeNine && activeNine < 190)
        {
            activeTen = rand((120..130).toList())
        }
        else if(190 <= activeNine && activeNine <= 200)
        {
            activeTen= rand((110..120).toList())
        }


        calledFour = true
    }



    if((globalYTwo[0] >=100 && globalYTwo[0] <= 200+10) || stateOne[0])
    {
        LaunchedEffect(globalYOne[0]) {
            while(globalYOne[0] <= 810) {
                withFrameNanos {
                    globalYOne[0] += speed
                }
                delay(16L)
            }
        }
        stateOne[0] = true
    }



    if((globalYTwo[1] > activeThree && globalYTwo[1] < activeThree+10) || stateOne[1])
    {
        LaunchedEffect(globalYOne[1]) {
            while(globalYOne[1] <= 810) {
                withFrameNanos {
                    globalYOne[1] += speed
                }
                delay(16L)
            }

        }
        stateOne[1] = true
    }



    if((globalYTwo[2] > activeFive && globalYTwo[2] < activeFive+10)|| stateOne[2])
    {
        LaunchedEffect(globalYOne[2]) {
            while(globalYOne[2] <= 810) {
                withFrameNanos {
                    globalYOne[2] += speed
                }
                delay(16L)
            }

        }
        stateOne[2] = true
    }

    if((globalYTwo[3] > activeSeven && globalYTwo[3] < activeSeven + 10)|| stateOne[3])
    {
        LaunchedEffect(globalYOne[3]) {
            while(globalYOne[3] <= 810) {
                withFrameNanos {
                    globalYOne[3] += speed
                }
                delay(16L)
            }

        }
        stateOne[3] = true
    }

    if((globalYTwo[4] > activeNine && globalYTwo[4] < activeNine + 10)|| stateOne[4])
    {
        LaunchedEffect(globalYOne[4]) {
            while(globalYOne[4] <= 810) {
                withFrameNanos {
                    globalYOne[4] += speed
                }
                delay(16L)
            }

        }
        stateOne[4] = true
    }



    if(globalYOne[0] >= 810 )
    {
        globalColorOne[0]= customBlue
        stateOne[0] = false
        globalYOne[0] = -50
        boxHitOne[0] = false
    }

    if(globalYOne[1] >= 810)
    {
        globalColorOne[1]= customBlue
        stateOne[1] = false
        globalYOne[1] = -50
        boxHitOne[1] = false

    }

    if(globalYOne[2] >= 810)
    {
        globalColorOne[2]= customBlue
        stateOne[2] = false
        globalYOne[2] =  -50
        boxHitOne[2] = false

    }

    if(globalYOne[3] >= 810)
    {
        globalColorOne[3]= customBlue
        stateOne[3] = false
        globalYOne[3] =  -50
        boxHitOne[3] = false

    }

    if(globalYOne[4] >= 810)
    {
        globalColorOne[4]= customBlue
        stateOne[4] = false
        globalYOne[4] =  -50
        boxHitOne[4] = false
    }

    // Second Column


    LaunchedEffect(globalYTwo[0]) {
        while(globalYTwo[0] < finalDistanceTwo) {
            withFrameNanos {
                globalYTwo[0] += speed
            }
            delay(16L)
        }
    }



    if(globalYTwo[0] > posTwo || stateTwo[0])
    {
        LaunchedEffect(globalYTwo[1]) {
            while(globalYTwo[1] < finalDistanceTwo) {
                withFrameNanos {
                    globalYTwo[1] += speed
                }
                delay(16L)
            }

        }
        stateTwo[0] = true
    }

    if(globalYTwo[1] > posTwo || stateTwo[1])
    {
        LaunchedEffect(globalYTwo[2]) {
            while(globalYTwo[2] < finalDistanceTwo) {
                withFrameNanos {
                    globalYTwo[2] += speed
                }
                delay(16L)
            }

        }
        stateTwo[1] = true
    }

    if(globalYTwo[2] > posTwo|| stateTwo[2])
    {
        LaunchedEffect(globalYTwo[3]) {
            while(globalYTwo[3] < finalDistanceTwo) {
                withFrameNanos {
                    globalYTwo[3] += speed
                }
                delay(16L)
            }

        }
        stateTwo[2] = true
    }

    if(globalYTwo[3] > posTwo|| stateTwo[3])
    {
        LaunchedEffect(globalYTwo[4]) {
            while(globalYTwo[4] < finalDistanceTwo) {
                withFrameNanos {
                    globalYTwo[4] += speed
                }
                delay(16L)
            }

        }
        stateTwo[3] = true
    }



    if(globalYTwo[0] >= finalDistanceTwo)
    {
        globalYTwo[0] = -100
        called = false
        globalColorTwo[0] = customBlue
        boxHitTwo[0] = false
    }

    if(globalYTwo[1] >= finalDistanceTwo)
    {
        globalColorTwo[1] = customBlue
        calledOne = false
        stateTwo[0] = false
        globalYTwo[1] = -100
        boxHitTwo[1] = false
    }

    if(globalYTwo[2] >= finalDistanceTwo)
    {
        globalColorTwo[2] = customBlue
        calledTwo = false
        stateTwo[1] = false
        globalYTwo[2] = -100
        boxHitTwo[2] = false
    }

    if(globalYTwo[3] >= finalDistanceTwo)
    {
        globalColorTwo[3] = customBlue
        calledThree = false
        stateTwo[2] = false
        globalYTwo[3] = -100
        boxHitTwo[3] = false
    }

    if(globalYTwo[4] >= finalDistanceTwo)
    {
        globalColorTwo[4] = customBlue
        calledFour = false
        stateTwo[3] = false
        globalYTwo[4] = -100
        boxHitTwo[4] = false
    }


    // third

    if((globalYTwo[0] > activeTwo && globalYTwo[0] < activeTwo+10) || stateThree[0])
    {
        LaunchedEffect(globalYThree[0]) {
            while(globalYThree[0] <= 810) {
                withFrameNanos {
                    globalYThree[0] += speed
                }
                delay(16L)
            }

        }
        stateThree[0] = true
    }



    if((globalYTwo[1] > activeFour && globalYTwo[1] < activeFour+10)|| stateThree[1])
    {
        LaunchedEffect(globalYThree[1]) {
            while(globalYThree[1] <= 810) {
                withFrameNanos {
                    globalYThree[1] += speed
                }
                delay(16L)
            }

        }
        stateThree[1] = true
    }

    if((globalYTwo[2] > activeSix && globalYTwo[2] < activeSix+10)|| stateThree[2])
    {
        LaunchedEffect(globalYThree[2]) {
            while(globalYThree[2] <= 810) {
                withFrameNanos {
                    globalYThree[2] += speed
                }
                delay(16L)
            }

        }
        stateThree[2] = true
    }

    if((globalYTwo[3] > activeEight && globalYTwo[3] < activeEight+10)|| stateThree[3])
    {
        LaunchedEffect(globalYThree[3]) {
            while(globalYThree[3] <= 810) {
                withFrameNanos {
                    globalYThree[3] += speed
                }
                delay(16L)
            }

        }
        stateThree[3] = true
    }

    if((globalYTwo[4] > activeTen && globalYTwo[4] < activeTen+10)|| stateThree[4])
    {
        LaunchedEffect(globalYThree[4]) {
            while(globalYThree[4] <= 810) {
                withFrameNanos {
                    globalYThree[4] += speed
                }
                delay(16L)
            }

        }
        stateThree[4] = true
    }




    if(globalYThree[0] >= 810)
    {
        globalColorThree[0] = customBlue
        stateThree[0] = false
        globalYThree[0] = -50
        boxHitThree[0] = false
    }

    if(globalYThree[1] >= 810)
    {
        globalColorThree[1] = customBlue
        stateThree[1] = false
        globalYThree[1] = -50
        boxHitThree[1] = false
    }


    if(globalYThree[2] >= 810)
    {
        globalColorThree[2] = customBlue
        stateThree[2] = false
        globalYThree[2] = -50
        boxHitThree[2] = false
    }
    if(globalYThree[3] >= 810)
    {
        globalColorThree[3] = customBlue
        stateThree[3] = false
        globalYThree[3] = -50
        boxHitThree[3] = false
    }

    if(globalYThree[4] >= 810)
    {
        globalColorThree[4] = customBlue
        stateThree[4] = false
        globalYThree[4] = -50
        boxHitThree[4] = false
    }



}



fun tomCheck()
{
    val rangeObstacle = 670..710
    val obstacleGridOne = globalYOne.any { it in rangeObstacle }
    val obstacleGridTwo = globalYTwo.any { it in rangeObstacle }
    val obstacleGridThree = globalYThree.any { it in rangeObstacle }



    if(tomX == 70)
    {
        if(obstacleGridOne)
        {
            tomX = 195
        }
    }

    if(tomX == 320)
    {
        if(obstacleGridThree)
        {
            tomX = 195
        }
    }

    if(tomX == 195)
    {
        if(obstacleGridTwo)
        {
            val indexInRangeTwo: Int = globalYTwo.withIndex()
                .first { it.value in rangeObstacle }
                .index

            if(indexInRangeTwo < 3)
            {
                if(globalYOne[indexInRangeTwo + 1] > globalYThree[indexInRangeTwo + 1])
                {
                    tomX = 320
                }
                else
                {
                    tomX = 70
                }
            }
            else
            {
                if(globalYOne[indexInRangeTwo] > globalYThree[indexInRangeTwo ])
                {
                    tomX = 320
                }
                else
                {
                    tomX = 70
                }
            }

        }
    }
}

@Composable
fun GreyGrid()
{
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(100.dp)
        .offset(20.dp,0.dp)
        .background(color = gridColor))
    {

    }

    Box(modifier = Modifier
        .fillMaxHeight()
        .width(100.dp)
        .offset(145.dp,0.dp)
        .background(color = gridColor))
    {

    }

    Box(modifier = Modifier
        .fillMaxHeight()
        .width(100.dp)
        .offset(270.dp,0.dp)
        .background(color = gridColor))
    {

    }
}



@Composable
fun SwipeableBox() {
    var offsetX by remember { mutableStateOf(0f) }
    val sensitivityThreshold = 30f

    Box(
        modifier = Modifier
            .fillMaxSize() 
            .pointerInput(jerryX,bulletX) {
                detectHorizontalDragGestures { change, dragAmount ->
                    if (dragAmount.absoluteValue > sensitivityThreshold) {if (dragAmount > 0) {
                
                        when (jerryX) {
                            71 -> jerryX = 196
                            196 -> jerryX = 321
                        }

                        when (bulletX) {
                            69 -> bulletX = 194
                            194 -> bulletX = 319
                        }


                    } else {
                        when (jerryX) {
                            321 -> jerryX = 196
                            196 -> jerryX = 71
                        }

                        when (bulletX) {
                            319 -> bulletX = 194
                            194 -> bulletX = 69
                        }
                    }
                    }
                }

            }
            .pointerInput(jerrySize) {
                detectVerticalDragGestures { change, dragAmount ->
                    if (dragAmount < -50) {
                        jumpUp = true
                        jerryOnAir = true
                    }
                }
            }
            .pointerInput(bulletStart) {
                detectTapGestures(
                    onDoubleTap = {
                        bulletStart = true
                    }
                )
            }
    )

    if(jumpUp)
    {
        LaunchedEffect(jerrySize){
            while(jerrySize < 40){
                jerrySize += 1
                delay(1000L)
            }


        }

    }

    if (jerrySize == 39 || jerrySize == 40)
    {
        jumpUp = false
        jumpDown = true
    }


    if ( jumpDown ) {
        jumpUp = false
        LaunchedEffect(jerrySize) {
            while(jerrySize >= 20){
                jerrySize -= 1
                delay(100L)

            }

        }
    }

    if (jerrySize == 19 )
    {
        jumpDown = false
        jerrySize = 20
        jerryOnAir = false
    }


}

@Composable
fun DrawHorizontalLine() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Draw a horizontal line at 100.dp from the top
        val yPosition = 600.dp.toPx() // Convert 100.dp to pixels
        drawLine(
            color = Color.Black,
            start = androidx.compose.ui.geometry.Offset(0f, yPosition),
            end = androidx.compose.ui.geometry.Offset(size.width, yPosition),
            strokeWidth = 5.dp.toPx() // Set the line thickness
        )
    }
}

@Composable
fun collisionChecker()
{
    val range = 500..700
    val density = 2.75
    val squareDp = 115/density
    var collisonRange: Int = 0

    val circlepoints = mutableListOf<Pair<Int, Int>>()
    val squarepoints = mutableListOf<Pair<Int,Int>>()



        if(jerryX == 71)
        {
            if(globalYOne.any {it > 500 && it <700 }  )
            {
                collisonRange = globalYOne.withIndex()
                    .first { it.value in range }
                    .index
            }

        }
        else if(jerryX == 196)
        {
            if(globalYTwo.any { it > 500 && it <700 }  )
            {
                collisonRange = globalYTwo.withIndex()
                    .first { it.value in range }
                    .index
            }

        }
        else if(jerryX == 321)
        {
            if(globalYThree.any { it > 500 && it < 700 })
            {
                collisonRange = globalYThree.withIndex()
                    .first { it.value in range }
                    .index
            }

        }

        val topLeftY = if(jerryX == 71) globalYOne[collisonRange] else if(jerryX == 196) globalYTwo[collisonRange] else globalYThree[collisonRange]

        val squareLeft = if(jerryX == 71) 50 else if(jerryX == 196) 175 else 300
        val squareRight = squareLeft + squareDp.toInt()
        val squareTop = topLeftY.toInt()
        val squareBottom = (topLeftY + squareDp).toInt()

        for (a in squareLeft..squareRight) {
            for (b in squareTop..squareBottom) {
                // Only add points on the perimeter of the square
                if (a == squareLeft || a == squareRight || b == squareTop || b == squareBottom) {
                    squarepoints.add(Pair(a, b))
                }
            }
        }



    // circle

    for ( x in (jerryX-20) .. (jerryX+20) )
    {
        for (y in 580..620)
        {
            if((x - jerryX)*(x - jerryX) + (y- 600)*(y- 600) == 400)
            {
                circlepoints.add(Pair(x,y))
            }
        }
    }






    if(!jerryOnAir && globalColorOne[collisonRange] != Color.Transparent && jerryX == 71 )
    {

        for (point in circlepoints) {
            if (point in squarepoints) {
                if(!boxHitOne[collisonRange])
                {
                    if(globalColorOne[collisonRange] == customBlue)
                    {
                        hit = true
                    }
                    else
                    {
                        trapActivate = true
                    }

                    boxHitOne[collisonRange] = true

                }

            }
        }

    }
    if(!jerryOnAir && globalColorTwo[collisonRange] != Color.Transparent && jerryX == 196 )
    {

        for (point in circlepoints) {
            if (point in squarepoints) {
                if(!boxHitTwo[collisonRange])
                {
                    if(globalColorTwo[collisonRange] == customBlue)
                    {
                        hit = true
                    }
                    else
                    {
                        trapActivate = true
                    }

                    boxHitTwo[collisonRange] = true

                }

            }
        }


    }
    if(!jerryOnAir && globalColorThree[collisonRange] != Color.Transparent && jerryX == 321 )
    {


        for (point in circlepoints) {
            if (point in squarepoints) {
                if(!boxHitThree[collisonRange])
                {
                    if(globalColorThree[collisonRange] == customBlue)
                    {
                        hit = true
                    }
                    else
                    {
                        trapActivate = true
                    }

                    boxHitThree[collisonRange] = true

                }

            }
        }


    }




//    if(jerryOnAir)
//    {
//        LaunchedEffect(Unit) {
//            delay(1800)
//            jerryOnAir = false
//
//        }
//    }




    if(hit)
    {
        if(hitCount == 0)
        {
            tomY = 750
        }
        else
        {
            tomY = 600
            gameOver = true
        }

        hitCount +=1
        hit = false
    }



}




fun rand(list:List<Int>):Int
{
    val randomIndex = (0 until list.size).random()
    return list[randomIndex]
}


fun randomiser(list:List<Long>):Long
{
    val randomIndex = (0 until list.size).random()
    return list[randomIndex]
}

@Composable
fun circle(X:Int,Y:Int,R:Int,color:Color)
{
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = color,
            radius = R.dp.toPx(), 
            center = Offset(X.dp.toPx(), Y.dp.toPx()) 
        )

        drawCircle(
            color = Color.Black,
            radius = R.dp.toPx(),
            center = Offset(X.dp.toPx(), Y.dp.toPx()),
            style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
        )


    }
}


@Composable
fun Square( offsetX:Int,offsetY:Int,color:Color) {
    val squareSize = 115f
    Canvas(modifier = Modifier
        .fillMaxSize()
        .offset(offsetX.dp, offsetY.dp)) {


        drawRect(
            color = color,
            size = Size(squareSize, squareSize)
        )
        drawRect(
            color = if(color != Color.Transparent) Color.Black else  Color.Transparent,
            size = Size(squareSize, squareSize),
            style = Stroke(width = 3.dp.toPx()) 
        )
    }
}

//@Composable
//fun SquareTrap( offsetX:Int,offsetY:Int,color:Color,caught:Boolean) {

//
//    val squareSize = if(!caught) 75f else 0f
//    Canvas(modifier = Modifier
//        .size(squareSize.dp)
//        .offset(offsetX.dp, offsetY.dp)) {
//        val halfSquareSize = squareSize / 2
//
//        rotate(degrees = rotationAngle, pivot = center) {
//            drawRect(
//                color = color,
//                topLeft = center.copy(x = center.x - halfSquareSize, y = center.y - halfSquareSize),
//                size = androidx.compose.ui.geometry.Size(squareSize, squareSize)
//            )
//            drawRect(
//                color = Color.Black,
//                topLeft = center.copy(x = center.x - halfSquareSize, y = center.y - halfSquareSize),
//                size = androidx.compose.ui.geometry.Size(squareSize, squareSize),
//                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 3.dp.toPx()) // Border width
//            )
//        }
//        drawCircle(
//            color = Color.Red,
//            radius = 2.dp.toPx(),
//            center = center
//        )
//    }
//}

//@Composable
//fun SquareTrap(offsetX: Int, offsetY: Int, color: Color, caught: Boolean) {
//    val squareSize = if (!caught) 75f else 0f
//
//    val infiniteTransition = rememberInfiniteTransition()
//    val rotationAngle by infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = 360f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 2000, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        )
//    )
//
//    Canvas(modifier = Modifier
//        .fillMaxSize()
//        .offset(offsetX.dp, offsetY.dp)) {
//
//        rotate(degrees = rotationAngle, pivot = center) {
//
//        drawRect(
//            color = color,
//            size = Size(squareSize, squareSize)
//        )
//        drawRect(
//            color = Color.Black,
//            size = Size(squareSize, squareSize),
//            style = Stroke(width = 3.dp.toPx()) 
//        )
//    }}
//}

@Composable
fun SquareTrap(offsetX: Int, offsetY: Int, color: Color, caught: Boolean,high :Boolean) {
    val squareSize = if (!caught) if (!high) 75f else 90f else 0f

    val infiniteTransition = rememberInfiniteTransition()
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = Modifier
        .size(squareSize.dp)
        .offset(offsetX.dp, offsetY.dp)) {

        rotate(degrees = rotationAngle, pivot = Offset(squareSize / 2, squareSize / 2)) {
            drawRect(
                color = color,
                size = Size(squareSize, squareSize)
            )
            drawRect(
                color = Color.Black,
                size = Size(squareSize, squareSize),
                style = Stroke(width = 3.dp.toPx()) 
            )
        }
    }
}

@Composable
fun Bullet(offsetX: Int, offsetY: Int, bulletHit: Boolean) {
    val bulletWidth = if (!bulletHit) 15f else 0f 
    val bulletHeight = if (!bulletHit) 30f else 0f 
    val borderWidth = if (!bulletHit) 10f else 0f

    Canvas(modifier = Modifier
        .width(bulletWidth.dp)
        .height(bulletHeight.dp)
        .offset(offsetX.dp, offsetY.dp)) {

            drawRect(
                color = Color.Gray,
                size = Size(bulletWidth, bulletHeight)
            )
            drawRect(
                color = Color.Black,
                size = Size(bulletWidth, bulletHeight),
                style = Stroke(width = 3.dp.toPx()) 
            )

    }
}


