package benworks.java.net.example;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author Ben
 */
public class InetAddressExample {
	public static void main(String[] args) {
		// Get the network inteface and associate addresses for this
		try {
			Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			if (interfaceList == null) {
				System.out.println("--No interfaces found--");
			} else {
				while (interfaceList.hasMoreElements()) {
					NetworkInterface iface = interfaceList.nextElement();
					System.out.println("Interfaces " + iface.getName() + ":");
					Enumeration<InetAddress> addrList = iface.getInetAddresses();
					if (!addrList.hasMoreElements()) {
						System.err.println("\t(No addresses for this interface)");
					}
					while (addrList.hasMoreElements()) {
						InetAddress address = (InetAddress) addrList.nextElement();
						System.err.println("\tAddress"
								+ ((address instanceof Inet4Address ? "(v4)" : (address instanceof Inet6Address ? "V6"
										: "(？)"))));
						System.out.println(":" + address.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			System.out.println("Error getting network interfaces" + e.getMessage());
		}

		// Get name(s)/address(es) of hosts given on commands line

		for (String host : args) {
			try {
				System.out.println(host + ":");
				InetAddress[] addressList = InetAddress.getAllByName(host);
				for (InetAddress address : addressList) {
					System.out.println("\t" + address.getHostName() + "/t" + address.getHostAddress());
				}
			} catch (UnknownHostException e) {
				System.out.println("\t Unable to find address for" + host);
			}
		}
	}
}
