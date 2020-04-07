/**
 *  BOND Motorized Shade
 *
 *  Copyright 2019-2020 Dominick Meglio
 *
 */

metadata {
    definition (
		name: "BOND Motorized Shade", 
		namespace: "bond", 
		author: "dmeglio@gmail.com",
		importUrl: "https://raw.githubusercontent.com/dcmeglio/hubitat-bond/master/drivers/BOND_Motorized_Shade.groovy"
	) {
        capability "WindowShade"
		capability "Switch"
		command "fixShade", [[name:"Shade*", type: "ENUM", description: "Shade", constraints: ["open","close"] ] ]
		command "hold"
    }
}

def open() {
	parent.handleOpen(device, device.deviceNetworkId.split(":")[1])
}

def close() {
	parent.handleClose(device, device.deviceNetworkId.split(":")[1])
}

def hold() {
	parent.handleHold(device, device.deviceNetworkId.split(":")[1])
}

def on() {
	open()
}

def off() {
	close()
}

def fixShade(shade) {
	parent.fixShadeState(device, device.deviceNetworkId.split(":")[1], shade)
}
