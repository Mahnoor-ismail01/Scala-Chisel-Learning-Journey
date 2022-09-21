
package labno6
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class pisotest extends FreeSpec with ChiselScalatestTester{
    "task2lab6" in {
        test(new shift_reg_with_parallel_load(4)){
            c=>
            c.io.in.poke(1.B)
            c.io.load_in(0).poke(1.B)
            c.io.load.poke(1.B)
            c.clock.step(10)
            //c.io.out.expect(1.B)
        }
    }
}