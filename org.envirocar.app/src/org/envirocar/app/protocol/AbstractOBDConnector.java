/* 
 * enviroCar 2013
 * Copyright (C) 2013  
 * Martin Dueren, Jakob Moellers, Gerald Pape, Christopher Stephan
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 * 
 */
package org.envirocar.app.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.envirocar.app.commands.CommonCommand;
import org.envirocar.app.commands.IntakePressure;
import org.envirocar.app.commands.IntakeTemperature;
import org.envirocar.app.commands.MAF;
import org.envirocar.app.commands.RPM;
import org.envirocar.app.commands.Speed;

public abstract class AbstractOBDConnector {

	public List<CommonCommand> getRequestCommands() {
		List<CommonCommand> result = new ArrayList<CommonCommand>();
		result.add(new Speed());
		result.add(new MAF());
		result.add(new RPM());
		result.add(new IntakePressure());
		result.add(new IntakeTemperature());
		return result;
	}
	
	public abstract void runCommand(CommonCommand cmd, InputStream in, OutputStream out) throws IOException;
	
	public abstract List<CommonCommand> getInitializationCommands();
	
	public abstract boolean supportsDevice(String deviceName);

	public abstract void processInitializationCommand(CommonCommand cmd);

	public abstract boolean connectionVerified();

	
}
