/**
 * BukkitOPPrefix
 * Copyright (c) 2016-2021, Sindastra <https://github.com/sindastra>
 * All rights reserved.
 *
 * This and the above copyright notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * This software is not affiliated with Bukkit and/or Spigot.
 * 
 * @author Sindastra
 * @copyright Copyright (c) 2016-2021, Sindastra. All rights reserved.
 */

package io.github.sindastra.BukkitOPPrefix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	
	private String prefix;
	private boolean showForOp;

	@Override
	public void onEnable()
	{
		saveDefaultConfig();
		prefix = getConfig().getString("prefix");
		showForOp = getConfig().getBoolean("show-for-op");
		
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("Copyright (c) 2016-2021, Sindastra. All rights reserved.");
		getLogger().info("This program is distributed in the hope that it will be useful,");
		getLogger().info("but WITHOUT ANY WARRANTY; without even the implied warranty of");
		getLogger().info("MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.");
		getLogger().info("See https://github.com/sindastra/BukkitOPPrefix");
		getLogger().info("Enabled!");
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("Disabled.");
	}
	
	@EventHandler
	public void onChatMessageSent(AsyncPlayerChatEvent event)
	{
		if ( (event.getPlayer().isOp() && showForOp) || event.getPlayer().hasPermission("opprefix.show") )
		{
			event.setFormat(prefix + "<%s> %s");
		}
	}
	
}
