#!/bin/bash

# Install Options Analyzer Scheduler
# Runs every Friday at 5:00 PM (after market close)

PLIST_NAME="com.ben.optionsanalyzer.plist"
PLIST_SRC="/Users/elgatomacmain/Desktop/Ben/Work/OptionsAnalyzer/$PLIST_NAME"
PLIST_DST="$HOME/Library/LaunchAgents/$PLIST_NAME"

echo "Installing Options Analyzer scheduler..."

# Copy plist to LaunchAgents
cp "$PLIST_SRC" "$PLIST_DST"

# Load the scheduler
launchctl unload "$PLIST_DST" 2>/dev/null
launchctl load "$PLIST_DST"

echo ""
echo "✓ Installed! The analyzer will run automatically:"
echo "  → Every Friday at 5:00 PM"
echo "  → Reports saved to: predictions/"
echo "  → Logs saved to: logs/"
echo ""
echo "To check status:  launchctl list | grep optionsanalyzer"
echo "To uninstall:     launchctl unload ~/Library/LaunchAgents/$PLIST_NAME"
echo "To run now:       python3 options_analyzer.py"
