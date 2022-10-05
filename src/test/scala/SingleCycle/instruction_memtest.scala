package SingleCycle
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class inn_MEM_test extends FreeSpec with ChiselScalatestTester{
    "instructon mem single cycle" in {
        test(new Instruction_Memory()){
            c=>
            c.io.addr.poke(4.U)
            c.clock.step(1)
            c.io.inst.expect("h00004137".U)
        }
}
}