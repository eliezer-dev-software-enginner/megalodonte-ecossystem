from config import CONFIG

_profile = CONFIG.profile("updater")
UPDATER_NAME = _profile["launcher_name"]
UPDATER_MAIN_CLASS = _profile["launcher_class"]
UPGRADE_UUID = CONFIG.upgrade_uuid
