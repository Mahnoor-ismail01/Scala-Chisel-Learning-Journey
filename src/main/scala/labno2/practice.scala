// package labno2
// import chisel3._
// import chisel3.util._

// class  widthinference extends Module{
//     val io=IO(new Bundle{
//         val x = Input(UInt(2.W))
//         val y = Input(UInt(2.W))
//         val sum = Output(UInt(2.W))
//          val sum1 = Output(UInt(2.W))
//          val sumW = Output(UInt(2.W))
//     })


// io.sum1 := io.x + io.y // OR
// io.sum:= io.x +% io.y
// io.sumW:= io.x +& io.y}
// class BitFieldManipulation extends Module{
//     val io = IO(new Bundle{
//         val xMSB = Input(UInt(2.W))
        
//         val yLowByte=Input(UInt(2.W))
//         val highbyte=Input(UInt(2.W))
        
//         val address=Output(UInt(2.W))

       



//     })

//     io.address:=Cat(io.highbyte,io.yLowByte)
// }
// class Bitpat1 extends Module{
//     def opCode_BEQ = BitPat ( " b000 ?????1100011 " )
// def opCode_BLT = BitPat ( " b100 ?????1100011 " )
// val counter=RegInit(1.U)
// // opcode matching with don ' t care bits
// when ( opCode_BEQ === " b000110001100011 " . U ) {
//     counter:=0.U+1.U

// }
// }