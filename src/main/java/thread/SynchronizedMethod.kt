package thread


object Main {
    @JvmStatic
    fun main(args: Array<String>) {
//        one()
        two()
    }

    fun one() {
        val test = TestObject()
        val threadA = ThreadA(test)
        val threadB = ThreadB(test)
        threadA.start()
        threadB.start()
    }

    fun two() {
        val test = TestObject()
        val test2 = TestObject()
        val threadB = ThreadB(test2)
        threadB.start()


        var threadA: Thread? = null
//        threadA = ThreadA(test)
        threadA?.customFun() ?: run {
            println("fdfjdf")
            ThreadA(test)
        }.customFun()

    }
}

fun Thread.customFun() {
    start()
}

class ThreadA(val `object`: TestObject) : Thread("ThreadA") {

    override fun run() {
        super.run()
        `object`.methodA()

    }
}

class ThreadB(val `object`: TestObject) : Thread("ThreadB") {

    override fun run() {
        super.run()
        `object`.methodA()
    }
}


class TestObject {

    @Synchronized
    fun methodA() {
        println("begin methodA threadName = ${Thread.currentThread().name}")
        Thread.sleep(5000)
        println("end")
    }
}


