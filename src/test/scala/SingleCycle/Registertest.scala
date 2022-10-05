
package SingleCycle
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._
class RegTest extends FreeSpec with ChiselScalatestTester{
    "reg single cycle" in {
        test(new Register_file_io()){
            c=>
            c.io.addRS1.poke(4.U)
            c.io.addRS2.poke(3.U)
            c.io.addWrite.poke(1.U)
           // c.io.addRD.poke(3.U)

            c.io.DataWrite.poke(23.S)
            c.io.RegWriteEnable.poke(1.B)
            c.clock.step(1)
            c.io.RS1Data.expect(4.S)
            c.io.RS2Data.expect(3.S)

        }
    }
}
