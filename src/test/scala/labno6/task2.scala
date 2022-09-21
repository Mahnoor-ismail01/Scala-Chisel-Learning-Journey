package labno6
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class counterXor extends FreeSpec with ChiselScalatestTester{
    "task2lab6" in {
        test(new XorCounter()){
            c=>
            c.clock.step(100)
            c.io.out.expect(1.U)
           
        }
    }
}
