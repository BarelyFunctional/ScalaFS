package org.barelyfunctional.tools.scalafs

import java.io.InputStream

trait Entry {
  def name : String
}

trait File extends Entry {
  def length : Long
  def content : InputStream
}

trait Directory extends Entry {
  def list : List[Entry]
}

