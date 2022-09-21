package labno6
import chisel3._
import chiseltest._
import org.scalatest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class Twoshottimertest extends FreeSpec with ChiselScalatestTester{
    "lab6Ex3" in{
        test(new  TwoShotTimer ()){
            c=>
            c.io.reload.poke(1.B)
            //c.io.din.poke(2.U)
            c.clock.step(10)
           
        }
    }
}