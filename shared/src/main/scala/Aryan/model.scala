package Aryan

case class Build
(
  base: Build.Base,
  commands: List[Command]
)

object Build {
  enum Base {
    case EmptyImage
    case ImageHash(hash:Aryan.Hash)
  }
}

case class Hash(value: Array[Byte])

enum Command {
  case Update(key:String, value:String)
  case Delete(key:String)
}