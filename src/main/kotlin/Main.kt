fun main(args: Array<String>) {
    var m = arrayOf(
        charArrayOf('.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.'),
        charArrayOf('#', '.', '.', '.')
    )
    var e = 0 //移動に成功したら毎回ランダムで獲得する経験値
    var texp = 0 //合計経験値
    var lev = 0 //レベル
    println(m[0]);println(m[1]);println(m[2]);println(m[3])

    var a = 3; var b = 0; var s=0
    var r = readLine()!!
    while (r != "p") {
        m[a][b] = '.'
        if (r == "w") a -= 1
        else if (r == "a") b -= 1
        else if (r == "s") a += 1
        else if (r == "d") b += 1
        else s = 1
        if (a!=-1 && b!=-1 && a!=4 && b!=4 && s!=1){
            e = (Math.random()*1000+1).toInt()
            println(e)
            var c = keikenkansuu(e,texp,lev)
            texp = c.first
            lev = c.second
        }
        s = 0
        if (a == -1) a = 0; if (b == -1) b = 0; if (a == 4) a = 3; if (b == 4) b = 3
        m[a][b] = '#'
        println();println(m[0]);println(m[1]);println(m[2]);println(m[3])
        r = readLine()!!
    }
}

fun keikenkansuu(a:Int,b:Int,c:Int):Pair<Int,Int>{
    var texp = b
    var nlev = c
    if (nlev<100){
        try { //数字以外が入力されたときに例外処理するための関数
            texp += a.toInt()
        } catch (e: NumberFormatException) {
            println("文字列です")
        }

        while ((nlev+1)*50 <= texp){
            nlev += 1
            println("レベル $nlev になりました")
            if (100 <= nlev){
                println("レベル上限になりました")
                break
            }
        }
    }
    println("現レベル $nlev　合計経験値 $texp　次のレベルまで ${50-texp%50}")
    return Pair(texp,nlev)
}