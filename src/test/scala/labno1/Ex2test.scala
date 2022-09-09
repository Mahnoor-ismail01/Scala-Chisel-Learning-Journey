package labno1
import chisel3._
import org.scalatest._
import chiseltest._

class msb extends FreeSpec with ChiselScalatestTester{
    "testlab1" in { test(new CounterMSB(2.U)){
        c=>
        c.clock.step(100)
    }}}

    