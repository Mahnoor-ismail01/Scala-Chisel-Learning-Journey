package labno1
import chisel3._
import org.scalatest._
import chiseltest._

class Exercise1 extends FreeSpec with ChiselScalatestTester{
    "testlab1" in {
        test(new counter1(2.S)){
            c=>
            
            c.clock.step(1)
        }
    }
}