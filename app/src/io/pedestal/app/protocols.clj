; Copyright 2013 Relevance, Inc.

; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
; which can be found in the file epl-v10.html at the root of this distribution.
;
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
;
; You must not remove this notice, or any other, from this software.

(ns ^:shared io.pedestal.app.protocols
    "Protocols for Pedestal applications.")

(defprotocol Activity
  (start [this])
  (stop [this]))

(defprotocol PutMessage
  (put-message [this message]
    "Put a message in a queue."))

(defprotocol TakeMessage
  (pop-message [this]
    "Return the next message if one exists, otherwise return nil.")
  (take-message [this f]
    "When the next message is available, call (f message). Ensures that no
    other function gets the same message."))
