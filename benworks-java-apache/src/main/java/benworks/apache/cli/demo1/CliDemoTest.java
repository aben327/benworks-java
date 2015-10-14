package benworks.apache.cli.demo1;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * @author Ben
 * @date 2015年10月14日上午11:57:27
 */
public class CliDemoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arg = { "-h", "-c", "config.xml" };
		testOptions(arg);
	}

	private static void testOptions(String[] args) {
		Options options = new Options();
		Option opt = new Option("h", "help", false, "Print help");
		opt.setRequired(false);
		options.addOption(opt);

		opt = new Option("c", "configFile", false, "Name server config properties file");
		opt.setRequired(false);
		options.addOption(opt);

		opt = new Option("p", "printConfigItem", false, "Print all config item");
		opt.setRequired(false);
		options.addOption(opt);

		HelpFormatter hf = new HelpFormatter();
		hf.setWidth(110);
		CommandLine commandLine = null;
		CommandLineParser parser = new PosixParser();

		try {
			commandLine = parser.parse(options, args);
			if (commandLine.hasOption('h')) {
				hf.printHelp("testApp", options, true);
			}

			System.out.println("------------------------------");
			Option[] opts = commandLine.getOptions();
			if (opts != null) {
				for (Option option : opts) {
					String name = option.getLongOpt();
					String value = commandLine.getOptionValue(name);
					System.out.println(name + "=>" + value);
				}
			}
		} catch (ParseException e) {
			hf.printHelp("testApp", options, true);
		}
	}
}
