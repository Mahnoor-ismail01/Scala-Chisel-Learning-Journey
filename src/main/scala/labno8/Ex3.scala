package labno8
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source

trait Config {
// word length configuration parameter
val WLEN= 32
val INST_MEM_LEN=4
// ALU operation control signal width

}
class steamIns extends Bundle with Config{
   val addr=Input(UInt(WLEN.W))
   val inst=Output(UInt(WLEN.W))
}
class instmemory (initFile:String) extends Module with Config{
    val io=IO(new steamIns)
    val imem = Mem ( INST_MEM_LEN , UInt ( WLEN . W ) )
    loadMemoryFromFile ( imem , initFile )
    io.inst := imem ( io.addr / 4.U )
}

// object Generate_ProcessorTile extends App {
// var initFile = " /home/mano/video/TheDoc.txt "
// chisel3 . Driver . execute ( args , () => new instmemory ( initFile ) )
