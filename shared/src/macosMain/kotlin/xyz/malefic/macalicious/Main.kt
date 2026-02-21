package xyz.malefic.macalicious

import platform.AppKit.NSApplication
import platform.AppKit.NSApplicationActivationPolicy.NSApplicationActivationPolicyRegular
import platform.AppKit.NSBackingStoreBuffered
import platform.AppKit.NSTextField
import platform.AppKit.NSWindow
import platform.AppKit.NSWindowStyleMaskClosable
import platform.AppKit.NSWindowStyleMaskMiniaturizable
import platform.AppKit.NSWindowStyleMaskResizable
import platform.AppKit.NSWindowStyleMaskTitled
import platform.AppKit.labelWithString
import platform.Foundation.NSMakeRect

fun main() {
    val app = NSApplication.sharedApplication()
    app.setActivationPolicy(NSApplicationActivationPolicyRegular)

    val window =
        NSWindow(
            contentRect = NSMakeRect(0.0, 0.0, 480.0, 270.0),
            styleMask =
                NSWindowStyleMaskTitled or
                    NSWindowStyleMaskClosable or
                    NSWindowStyleMaskMiniaturizable or
                    NSWindowStyleMaskResizable,
            backing = NSBackingStoreBuffered,
            defer = false,
        )
    window.title = "Macalicious"
    window.center()
    window.makeKeyAndOrderFront(null)

    val label = NSTextField.labelWithString(Greeting().greet())
    label.frame = NSMakeRect(20.0, 120.0, 440.0, 30.0)
    window.contentView?.addSubview(label)

    app.activateIgnoringOtherApps(true)
    app.run()
}
