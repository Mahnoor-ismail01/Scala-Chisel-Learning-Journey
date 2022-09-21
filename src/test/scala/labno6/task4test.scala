package labno6
import chisel3._
import chiseltest._
import org.scalatest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class updowntest extends FreeSpec with ChiselScalatestTester{
    "lab6task4" in{
        test(new updowncounter (4)){
            c=>
            c.io.up_down.poke(1.B)
            //c.io.din.poke(2.U)
            c.clock.step(10)
           
        }
    }
}